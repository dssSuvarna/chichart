package com.activ8.chichart.api.service;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.api.exception.*;
import com.activ8.chichart.api.rest.resource.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.characteristics.*;
import com.activ8.chichart.core.service.chisymbol.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.month.*;
import com.activ8.chichart.core.service.snippet.*;
import com.activ8.chichart.domain.entity.*;
import com.activ8.chichart.domain.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.CollectionUtils;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
public class ChartServiceImpl implements ChartService {
	
	private static final Integer daysToMinus = 28;
	 
	private static final Integer daysToAdd = 28;

	private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

	private FateCycleService fateCycleService = ServiceFactory.getInstance().getFateCycleService();

	private LunarMethodService lunarMethodService = ServiceFactory.getInstance().getLunarMethodService();

	private CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();

	private SnippetService snippetService = ServiceFactory.getInstance().getSnippetService();

	private ChiSymbolService chiSymbolService = ServiceFactory.getInstance().getChiSymbolService();

	private PillarCharacteristicsService pillarCharacteristicsService = ServiceFactory.getInstance()
			.getPillarCharacteristicsService();

	private final RegistrationService registrationService;
	private final UserSubscriptionService userSubscriptionService;

	private final RegistrationLogic registrationLogic;
	private final PrivateUserService privateUserService;
	private final RegistrationRepository registrationRepository;

	@Autowired
	public ChartServiceImpl(RegistrationService registrationService, UserSubscriptionService userSubscriptionService,
			RegistrationLogic registrationLogic, PrivateUserService privateUserService,
			RegistrationRepository registrationRepository) {
		this.registrationService = registrationService;
		this.userSubscriptionService = userSubscriptionService;
		this.registrationLogic = registrationLogic;
		this.privateUserService = privateUserService;
		this.registrationRepository = registrationRepository;
	}

	@Override
	public ChartResource getChart(CalculateChartCommand command) {
		Registration loginUser = registrationService.getByUserKey(command.getUserKey());
		UserSubscription userSubscription = userSubscriptionService.getByUserKey(command.getUserKey());
		if (!registrationLogic.isInTrialPeriod(loginUser) && !(userSubscription == null)
				&& !registrationLogic.hasSubscription(command.getProductKey(), userSubscription.getDateOfCommencement(),
						userSubscription.getDateOfExpiry())) {
			throw new TrialPeriodExpiredException(
					String.format("User %s trial period started on %s and has now expired.", loginUser.getUserKey(),
							loginUser.getCreated()));
		}

		if (Objects.nonNull(command.getPrivateUserId())) {
			loginUser = privateUserService.getPrivateUser(command.getPrivateUserId(), command.getUserKey());
		}
		return getEnergies(command, loginUser);
	}

	@Override
	public ChartResource getEnergies(CalculateChartCommand command, Registration registration) {

		FourPillarsChart chart = fourPillarsService.getPillars(registration.getDateOfBirth(),
				registration.getTimeOfBirth() == null ? null : registration.getTimeOfBirth().getTime());
		Stem yearStem = chart.getYearPillar().getStem();
		List<FateCycle> fateCycles = fateCycleService.getFateCycles(registration.getDateOfBirth(),
				registration.getGender(), yearStem.getDuality().getType());
		FateCycle activeFateCycle = fateCycleService.getActiveFateCycle(registration.getDateOfBirth(),
				command.getChartDate(), fateCycles);
		LunarMethod lunarMethod = lunarMethodService.getLunarMethod(new LunarMethodCommand(chart,
				registration.getDateOfBirth(), registration.getGender(), command.getChartDate()));
		List<ElementType> rankedElements = lunarMethodService.getRankedElements(lunarMethod.getType(),
				chart.getDayPillar().getStem().getElement());
		CalendarData calendarData = new CalendarData(chart,
				lunarMethodService.getRankedStems(chart, lunarMethod, chart.getDayPillar().getStem().getElement()),
				lunarMethodService.getRankedBranches(chart, lunarMethod, chart.getDayPillar().getStem().getElement()));
		List<CalendarDay> calendarDays = calendarService.getCalendarDays(calendarData,
				command.getChartDate().minusDays(daysToMinus), command.getChartDate().plusDays(daysToAdd), registration.getDateOfBirth(),
				registration.getGender());
		snippetService.injectSnippets(lunarMethod.getType(), chart.getDayPillar().getStemType(), calendarDays);
		chiSymbolService.injectChiSymbols(chart, calendarDays);
		pillarCharacteristicsService.injectCharacteristics(chart.getDayPillar(), calendarDays);

		return ChartResource.builder().activeFateCycle(activeFateCycle).calendarData(calendarData)
				.calendarDays(calendarDays).chart(chart).fateCycles(fateCycles).lunarMethod(lunarMethod)
				.rankedElements(rankedElements).build();
	}

	@Override
	public List<UserWithMatchingEnergies> getAllPrivateUsersMatchingEnergiesByUserKey(CalculateChartCommand command) {
		Registration loginUser = registrationService.getByUserKey(command.getUserKey());
		UserSubscription userSubscription = userSubscriptionService.getByUserKey(command.getUserKey());
		if (!registrationLogic.isInTrialPeriod(loginUser) && !(userSubscription == null)
				&& !registrationLogic.hasSubscription(command.getProductKey(), userSubscription.getDateOfCommencement(),
						userSubscription.getDateOfExpiry())) {
			throw new TrialPeriodExpiredException(
					String.format("User %s trial period started on %s and has now expired.", loginUser.getUserKey(),
							loginUser.getCreated()));
		}
		
		// Get all private users linked to login user
		List<Registration> privateUsers = registrationRepository.findAllByParentUserId(loginUser.getId());
		if (CollectionUtils.isEmpty(privateUsers)) {
			throw new EntityNotFoundException(
					String.format("No private users found for this userKey %s", command.getUserKey()));
		}

		// Get energies of login user
		ChartResource loginUserChartResource = getEnergies(command, loginUser);
		List<DateAndChiSymbolDto> loginUserSymbols = loginUserChartResource.getCalendarDays().stream()
				.map(calenderDay -> DateAndChiSymbolDto.of(calenderDay.getDate(),
						calenderDay.getChiSymbolDetails().getChiSymbol()))
				.collect(Collectors.toList());
		
		// Get energies of all private users
		List<UserChartDto> privateUsersResources = privateUsers.stream().map(privateUser -> {
			command.setPrivateUserId(privateUser.getId());
			return UserChartDto.of(privateUser.getUserKey(), getEnergies(command, privateUser));
		}).collect(Collectors.toList());

		return privateUsersResources.stream()
				.map(resource -> getUserWithMatchingEnergies(resource, loginUserSymbols))
				.collect(Collectors.toList());

	}

	/**
	 * This method takes privateUsers energies and list the symbols for particular private user
	 * and check if any symbol is matching with loginUsers symbol with respect to date 
	 * and return userKey and matching energies with date if symbols are matching with respect to date 
	 *  
	 * @param privateUsersResource is energies of the privateUser 
	 * @param loginUserSymbols is list of chi-symbols of login user have with respect to date
	 * @return UserWithMatchingEnergies 
	 */
	private UserWithMatchingEnergies getUserWithMatchingEnergies(UserChartDto privateUsersResource,
			List<DateAndChiSymbolDto> loginUserSymbols) {
		List<DateAndChiSymbolDto> privateUserSymbols = privateUsersResource.getChart().getCalendarDays().stream()
				.map(calenderDay -> DateAndChiSymbolDto.of(calenderDay.getDate(),
						calenderDay.getChiSymbolDetails().getChiSymbol()))
				.collect(Collectors.toList());

		List<DateAndChiSymbolDto> matchingSymbols = privateUserSymbols.stream()
				.filter(privateUserSymbol -> loginUserSymbols.contains(privateUserSymbol))
				.collect(Collectors.toList());

		return UserWithMatchingEnergies.of(privateUsersResource.getUserKey(), matchingSymbols);
	}

}

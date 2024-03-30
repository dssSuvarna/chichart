package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;
import com.activ8.chichart.core.service.lunarmethod.competitive.*;
import com.activ8.chichart.core.service.lunarmethod.dominant.*;
import com.activ8.chichart.core.service.lunarmethod.output.*;
import com.activ8.chichart.core.service.lunarmethod.power.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;
import com.activ8.chichart.core.service.lunarmethod.resource.*;
import com.activ8.chichart.core.service.lunarmethod.wealth.*;

import java.time.*;
import java.util.*;

public class LunarMethodServiceImpl implements LunarMethodService {

    private List<LunarMethod> lunarMethods = new ArrayList<>();

    private LunarMethodRankLogic lunarMethodRankLogic = new LunarMethodRankLogic();

    private ElementRankLogic elementRankLogic;

    private FateCycleService fateCycleService;

    private FateCycleLogic fateCycleLogic;

    private FourPillarsLogic fourPillarsLogic;

    public LunarMethodServiceImpl(ElementRankLogic elementRankLogic, FateCycleService fateCycleService, FourPillarsLogic fourPillarsLogic, SeasonalCombinationLogic seasonalCombinationLogic,
                                  HarmonyCombinationLogic harmonyCombinationLogic, CombinationLogic combinationLogic, FateCycleLogic fateCycleLogic) {

        this.elementRankLogic = elementRankLogic;
        this.fateCycleService = fateCycleService;
        this.fourPillarsLogic = fourPillarsLogic;
        this.fateCycleLogic = fateCycleLogic;

        lunarMethods.add(new FollowThePowerSeasonal(seasonalCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowTheOutputSeasonal(seasonalCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowTheResourceSeasonal(seasonalCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowTheWealthSeasonal(seasonalCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowThePower());
        lunarMethods.add(new FollowTheResource());
        lunarMethods.add(new FollowTheOutput());
        lunarMethods.add(new FollowTheWealth());
        lunarMethods.add(new FollowTheResourceHarmony(harmonyCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowThePowerHarmony(harmonyCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowTheOutputHarmony(harmonyCombinationLogic, combinationLogic));
        lunarMethods.add(new FollowTheWealthHarmony(harmonyCombinationLogic, combinationLogic));
        lunarMethods.add(new Dominant(combinationLogic));
        lunarMethods.add(new DominantEarth());
        lunarMethods.add(new Competitive(seasonalCombinationLogic, harmonyCombinationLogic));

        Comparator<LunarMethod> comparator = Comparator.comparing(LunarMethod::getOrder);

        lunarMethods.sort(comparator);
    }

    public LunarMethod getLunarMethod(LunarMethodCommand command) {

        FourPillarsChart chart = command.getChart();
        int currentAge = Period.between(command.getDob(), command.getCalendarDate()).getYears();

        LunarMethod lunarMethod = getLunarMethod(chart, currentAge);


        if (lunarMethod == null) {
            List<FateCycle> fateCycles = fateCycleService.getFateCycles(command.getDob(), command.getGender(), chart.getYearPillar().getStem().getDuality().getType());
            FateCycle activeFateCycle = fateCycleService.getActiveFateCycle(command.getDob(), command.getCalendarDate(), fateCycles);

            // use stem for the first 5 years of a fate cycle. use branch for other 5 years.
            boolean useStem = fateCycleLogic.isUseStem(activeFateCycle.getAge(), command.getDob(), command.getCalendarDate());
            chart.addPillar(new Pillar(PillarType.ACTIVE_FATE_CYCLE, useStem ? activeFateCycle.getStem() : null, useStem ? null : activeFateCycle.getBranch()));
            lunarMethod = getLunarMethod(chart, currentAge);
        }

        if (lunarMethod == null) {
            Pillar pillar = fourPillarsLogic.getYear(command.getCalendarDate());
            chart.addPillar(new Pillar(PillarType.CURRENT_YEAR, pillar.getStem(), pillar.getBranch()));
            lunarMethod = getLunarMethod(chart, currentAge);
        }

        if (lunarMethod == null) {
            Pillar pillar = fourPillarsLogic.getMonth(command.getCalendarDate());
            chart.addPillar(new Pillar(PillarType.CURRENT_MONTH, pillar.getStem(), pillar.getBranch()));
            lunarMethod = getLunarMethod(chart, currentAge);
        }

        if (lunarMethod == null) {
            Pillar pillar = fourPillarsLogic.getDay(command.getCalendarDate());
            chart.addPillar(new Pillar(PillarType.CURRENT_DAY, pillar.getStem(), pillar.getBranch()));
            lunarMethod = getLunarMethod(chart, currentAge);
        }

        // the same chart is used to calculate lunar methods for multiple dates. For each day, we want to clear out the non-core pillar types and only re-add them as required during
        // future calculations
        chart.removePillars(PillarType.ACTIVE_FATE_CYCLE, PillarType.CURRENT_YEAR, PillarType.CURRENT_MONTH, PillarType.CURRENT_DAY);
        return lunarMethod == null ? new UnknownLunarMethod() : lunarMethod;
    }

    private LunarMethod getLunarMethod(FourPillarsChart chart, int age) {

        LunarMethod lunarMethod = null;

        for (LunarMethod lm : lunarMethods) {
            if (lm.matches(chart, age)) {
                lunarMethod = lm;
                break;
            }
        }

        return lunarMethod;
    }

    public List<ElementType> getRankedElements(LunarMethodType lunarMethodType, Element element) {
        return lunarMethodRankLogic.getRankedElements(lunarMethodType, element);
    }

    /*
    Resist trying to perfect the domain model for this for now. Wont know how things should be properly modelled until we see the calcs for the
    other chart types
     */
    public List<RankedStem> getRankedStems(FourPillarsChart chart, LunarMethod lunarMethod, Element element) {
        return elementRankLogic.rankStems(chart, lunarMethod, getRankedElements(lunarMethod.getType(), element));
    }

    public List<RankedBranch> getRankedBranches(FourPillarsChart chart, LunarMethod lunarMethod, Element element) {
        return elementRankLogic.rankBranches(chart, lunarMethod, getRankedElements(lunarMethod.getType(), element));
    }
}

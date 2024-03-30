package com.activ8.chichart.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.activ8.chichart.api.command.CreatePrivateUserCommand;
import com.activ8.chichart.api.command.UpdatePrivateUserCommand;
import com.activ8.chichart.api.rest.converter.PrivateUserToResourceConverter;
import com.activ8.chichart.api.rest.resource.PrivateUserResource;
import com.activ8.chichart.domain.entity.Registration;
import com.activ8.chichart.domain.repository.RegistrationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PrivateUserServiceImpl implements PrivateUserService {

	private final RegistrationService registrationService;
	private final RegistrationRepository registrationRepository;

	@Override
	public Registration createPrivateUser(String userKey, CreatePrivateUserCommand command) {
		Registration parentUser = registrationService.getByUserKey(userKey);
		Registration privateUser = Registration.builder()
				.userKey(command.getPrivateUserName())
				.dateOfBirth(command.getDateOfBirth())
				.timeOfBirth(command.getTimeOfBirth())
				.gender(command.getGender())
				.platform(command.getPlatform())
				.parentUser(parentUser)
				.status(command.getStatus())
				.relationship(command.getRelationship())
				.build();
		return registrationRepository.saveAndFlush(privateUser);
	}

	@Override
	public Registration updatePrivateUser(UpdatePrivateUserCommand command, String userKey, Long privateUserId) {
		Registration privateUser = getPrivateUser(privateUserId, userKey);
		privateUser.setUserKey(command.getPrivateUserName());
		privateUser.setDateOfBirth(command.getDateOfBirth());
		privateUser.setTimeOfBirth(command.getTimeOfBirth());
		privateUser.setGender(command.getGender());
		privateUser.setPlatform(command.getPlatform());
		privateUser.setStatus(command.getStatus());
		privateUser.setRelationship(command.getRelationship());
		privateUser.setLastPayment(command.getLastPayment());
		return registrationRepository.saveAndFlush(privateUser);
	}

	@Override
	public Long deletePrivateUser(String userKey,Long privateUserId) {
		Registration privateUser = getPrivateUser(privateUserId, userKey);
		registrationRepository.delete(privateUser);
		return privateUser.getId();
	}

	@Override
	public Registration getPrivateUser(Long privateUserId, String userKey) {
		Registration parentUser = registrationService.getByUserKey(userKey);
		Optional<Registration> optionalPrivateUser = registrationRepository.findByIdAndParentUserId(privateUserId, parentUser.getId());
		if (!optionalPrivateUser.isPresent()) {
			throw new EntityNotFoundException(String.format("No private user found with id %s", privateUserId));
		}
		return optionalPrivateUser.get();
	}

	@Override
	public List<PrivateUserResource> getAllPrivateUsersByUserKey(String userKey) {
		Registration parentUser = registrationService.getByUserKey(userKey);
		List<Registration> privateUsers = registrationRepository.findAllByParentUserId(parentUser.getId());
		if (CollectionUtils.isEmpty(privateUsers)) {
			throw new EntityNotFoundException(
					String.format("No private users found for this userKey %s", userKey));
		}
		List<PrivateUserResource> privateUserResourceLists = privateUsers.stream()
				.map(privateUser -> new PrivateUserToResourceConverter().convert(privateUser))
				.sorted(Comparator.comparing(PrivateUserResource::getCreated).reversed())
				.collect(Collectors.toList());

		return privateUserResourceLists;
	}

}

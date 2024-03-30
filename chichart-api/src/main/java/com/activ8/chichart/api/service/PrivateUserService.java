package com.activ8.chichart.api.service;

import java.util.List;

import com.activ8.chichart.api.command.CreatePrivateUserCommand;
import com.activ8.chichart.api.command.UpdatePrivateUserCommand;
import com.activ8.chichart.api.rest.resource.PrivateUserResource;
import com.activ8.chichart.domain.entity.Registration;

public interface PrivateUserService {
	Registration createPrivateUser(String userKey, CreatePrivateUserCommand command);

	Registration getPrivateUser(Long privateUserId, String userKey);

	Registration updatePrivateUser(UpdatePrivateUserCommand command, String userKey, Long privateUserId);

	Long deletePrivateUser(String userKey, Long privateUserId);

	List<PrivateUserResource> getAllPrivateUsersByUserKey(String userKey);

}

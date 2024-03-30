package com.activ8.chichart.api.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.activ8.chichart.api.rest.resource.CreatePrivateUserResponse;
import com.activ8.chichart.api.rest.resource.ParentUserResponse;
import com.activ8.chichart.domain.entity.Registration;

@Component
public class CreatePrivateUserResponseConverter implements Converter<Registration, CreatePrivateUserResponse> {

	@Override
	public CreatePrivateUserResponse convert(Registration privateUser) {

		Registration parentUser = privateUser.getParentUser();
		ParentUserResponse parentUserResponse = ParentUserResponse.builder().parentUserId(parentUser.getId())
				.parentUserName(parentUser.getUserKey()).dateOfBirth(parentUser.getDateOfBirth())
				.timeOfBirth(parentUser.getTimeOfBirth()).gender(parentUser.getGender()).build();

		return CreatePrivateUserResponse.builder().privateUserId(privateUser.getId())
				.privateUserName(privateUser.getUserKey()).dateOfBirth(privateUser.getDateOfBirth())
				.timeOfBirth(privateUser.getTimeOfBirth()).gender(privateUser.getGender())
				.parentUser(parentUserResponse).build();
	}
}

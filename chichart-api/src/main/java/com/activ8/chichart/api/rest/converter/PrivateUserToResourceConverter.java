package com.activ8.chichart.api.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.activ8.chichart.api.rest.resource.PrivateUserResource;
import com.activ8.chichart.domain.entity.Registration;

@Component
public class PrivateUserToResourceConverter implements Converter<Registration, PrivateUserResource> {

	@Override
	public PrivateUserResource convert(Registration privateUser) {
		return PrivateUserResource.builder()
				.privateUserId(privateUser.getId())
   				.privateUserName(privateUser.getUserKey())
   				.dateOfBirth(privateUser.getDateOfBirth())
   				.timeOfBirth(privateUser.getTimeOfBirth())
   				.gender(privateUser.getGender())
   				.platform(privateUser.getPlatform())
   				.parentUser(privateUser.getParentUser().getUserKey())
   				.status(privateUser.getStatus())
   				.relationship(privateUser.getRelationship())
   				.lastPayment(privateUser.getLastPayment())
   				.created(privateUser.getCreated())
   				.updated(privateUser.getUpdated())
   				.build();
	}

}

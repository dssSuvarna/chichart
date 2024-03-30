package com.activ8.chichart.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activ8.chichart.api.rest.resource.CreatePrivateUserResource;
import com.activ8.chichart.api.rest.resource.CreatePrivateUserResponse;
import com.activ8.chichart.api.rest.resource.PrivateUserResource;
import com.activ8.chichart.api.rest.resource.UpdatePrivateUserResource;
import com.activ8.chichart.api.service.PrivateUserService;
import com.activ8.chichart.domain.entity.Registration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class PrivateUserController {

	private final PrivateUserService privateUserService;

	private final ConversionService chichartConversionService;

	@PostMapping("/{userKey}/privateUser")
	public CreatePrivateUserResponse createPrivateUser(@PathVariable String userKey,
			@RequestBody @Valid CreatePrivateUserResource privateUserResource) {
		Registration privateUser = privateUserService.createPrivateUser(userKey, privateUserResource);
		return chichartConversionService.convert(privateUser, CreatePrivateUserResponse.class);
	}

	@PutMapping("/{userKey}/privateUser/{privateUserId}")
	public ResponseEntity updatePrivateUser(@PathVariable String userKey, @PathVariable Long privateUserId,
			@RequestBody @Valid UpdatePrivateUserResource updatePrivateUserResource) {
		privateUserService.updatePrivateUser(updatePrivateUserResource, userKey, privateUserId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{userKey}/privateUser/{privateUserId}")
	public ResponseEntity deletePrivateUser(@PathVariable String userKey, @PathVariable Long privateUserId) {
		privateUserService.deletePrivateUser(userKey, privateUserId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{userKey}/privateUser/{privateUserId}")
	public PrivateUserResource getPrivateUser(@PathVariable String userKey, @PathVariable Long privateUserId) {
		Registration privateUser = privateUserService.getPrivateUser(privateUserId, userKey);
		return chichartConversionService.convert(privateUser, PrivateUserResource.class);
	}

	@GetMapping("/{userKey}/privateUser")
	public List<PrivateUserResource> getAllPrivateUserByUserKey(@PathVariable String userKey) {
		return privateUserService.getAllPrivateUsersByUserKey(userKey);
	}

}

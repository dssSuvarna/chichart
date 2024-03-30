package com.activ8.chichart.api.rest.resource;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import com.activ8.chichart.api.command.CreatePrivateUserCommand;
import com.activ8.chichart.constant.Gender;
import com.activ8.chichart.constant.HourPeriod;
import com.activ8.chichart.constant.Platform;
import com.activ8.chichart.constant.Status;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePrivateUserResource implements CreatePrivateUserCommand {
	@NonNull
	@NotBlank
	String privateUserName;
	
	@NonNull
	@NotBlank
	String relationship;

	LocalDate dateOfBirth;

	HourPeriod timeOfBirth;

	Gender gender;

	Platform platform;

	Status status;

}

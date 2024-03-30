package com.activ8.chichart.api.rest.resource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.activ8.chichart.api.command.UpdatePrivateUserCommand;
import com.activ8.chichart.constant.Gender;
import com.activ8.chichart.constant.HourPeriod;
import com.activ8.chichart.constant.Platform;
import com.activ8.chichart.constant.Status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class UpdatePrivateUserResource implements UpdatePrivateUserCommand {

	@NonNull
	@NotBlank
	String privateUserName;

	LocalDate dateOfBirth;

	HourPeriod timeOfBirth;

	Gender gender;

	Platform platform;

	Status status;

	LocalDateTime lastPayment;
	
	@NonNull
	@NotBlank
	String relationship;

}

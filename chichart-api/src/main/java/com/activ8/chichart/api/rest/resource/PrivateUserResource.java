package com.activ8.chichart.api.rest.resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
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
@Component
public class PrivateUserResource implements CreatePrivateUserCommand {

	Long privateUserId;

	@NonNull
	@NotBlank
	String privateUserName;
	
	String relationship;

	LocalDate dateOfBirth;

	HourPeriod timeOfBirth;

	Gender gender;
	
	String parentUser;

	Platform platform;

	Status status;

	LocalDateTime lastPayment;

	LocalDateTime created;

	LocalDateTime updated;
}

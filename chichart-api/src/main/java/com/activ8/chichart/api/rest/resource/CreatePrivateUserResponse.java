package com.activ8.chichart.api.rest.resource;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.activ8.chichart.constant.Gender;
import com.activ8.chichart.constant.HourPeriod;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreatePrivateUserResponse{

	Long privateUserId;

	String privateUserName;

	LocalDate dateOfBirth;

	HourPeriod timeOfBirth;

	Gender gender;
	
	ParentUserResponse parentUser;

}

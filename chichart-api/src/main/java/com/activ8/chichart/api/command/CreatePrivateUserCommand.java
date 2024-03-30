package com.activ8.chichart.api.command;

import java.time.LocalDate;

import com.activ8.chichart.constant.Gender;
import com.activ8.chichart.constant.HourPeriod;
import com.activ8.chichart.constant.Platform;
import com.activ8.chichart.constant.Status;

public interface CreatePrivateUserCommand {
	
	String getPrivateUserName();

	LocalDate getDateOfBirth();

	HourPeriod getTimeOfBirth();

	Gender getGender();

	Platform getPlatform();

	Status getStatus();
	
	String getRelationship();

}

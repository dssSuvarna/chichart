package com.activ8.chichart.api.command;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.activ8.chichart.constant.Gender;
import com.activ8.chichart.constant.HourPeriod;
import com.activ8.chichart.constant.Platform;
import com.activ8.chichart.constant.Status;

public interface UpdatePrivateUserCommand {

	String getPrivateUserName();

	LocalDate getDateOfBirth();

	void setDateOfBirth(LocalDate dateOfBirth);

	HourPeriod getTimeOfBirth();

	void setTimeOfBirth(HourPeriod timeOfBirth);

	Gender getGender();

	void setGender(Gender gender);

	Platform getPlatform();

	void setPlatform(Platform platform);

	Status getStatus();

	void setStatus(Status status);

	LocalDateTime getLastPayment();

	void setLastPayment(LocalDateTime lastPayment);
	
	String getRelationship();
	
	void setRelationship(String relationship);

}

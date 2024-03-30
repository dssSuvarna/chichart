package com.activ8.chichart.api.command;

import com.activ8.chichart.constant.*;

import java.time.*;

public interface UpdateRegistrationCommand {

    String getUserKey();

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
}

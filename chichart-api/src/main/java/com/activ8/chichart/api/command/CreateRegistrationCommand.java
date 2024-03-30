package com.activ8.chichart.api.command;

import com.activ8.chichart.constant.*;

import java.time.*;

public interface CreateRegistrationCommand {
    String getUserKey();
    LocalDate getDateOfBirth();
    HourPeriod getTimeOfBirth();
    Gender getGender();
    Platform getPlatform();
    Status getStatus();
}

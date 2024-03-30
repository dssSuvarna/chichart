package com.activ8.chichart.api.service;

import com.activ8.chichart.domain.entity.*;

import java.time.*;
import java.util.*;

public class RegistrationLogic {

    private int trialPeriodDays;

    public RegistrationLogic(int trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }


    boolean isInTrialPeriod(Registration registration) {
        return !registration.getCreated().plusDays(trialPeriodDays).isBefore(LocalDateTime.now());
    }

    boolean hasSubscription(String productKey, LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = LocalDate.now();
        return productKey != null
                && Arrays.asList("activ8.chichart.basicmonthly.v1").contains(productKey)
                && currentDate.compareTo(startDate) >= 0
                && currentDate.compareTo(endDate) <= 0;
    }

    public int getTrialPeriodDays() {
        return trialPeriodDays;
    }
}

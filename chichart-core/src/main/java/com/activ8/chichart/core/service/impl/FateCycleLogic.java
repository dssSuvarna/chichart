package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.time.*;
import java.util.*;

public class FateCycleLogic {

    private DataService dataService;

    public FateCycleLogic(DataService dataService) {
        this.dataService = dataService;
    }

    public Integer getFateCycleStartAge(LocalDate date, Gender gender, DualityType dualityType) {

        int daysToMonthBoundary = -1;
        List<Branch> branches = dataService.getBranches();

        boolean forward = isForward(gender, dualityType);

        if (forward) {
            while (!isStartofMonth(branches, date)) {
                daysToMonthBoundary++;
                date = date.plusDays(1);
            }
        } else {
            while (!isStartofMonth(branches, date)) {
                daysToMonthBoundary++;
                date = date.minusDays(1);
            }
        }

        // age at which fate cycles start
        return (int) Math.round((double) daysToMonthBoundary / 3d);
    }

    private boolean isStartofMonth(List<Branch> branches, LocalDate date) {
        Integer day = date.getDayOfMonth();
        Integer month = date.getMonth().getValue();

        for (Branch branch : branches) {
            if (branch.getWesternMonthStartDay().equals(day) && branch.getWesternMonthStartMonth().equals(month))
                return true;
        }

        return false;
    }

    public boolean isForward(Gender gender, DualityType dualityType) {
        if (gender.equals(Gender.FEMALE)) {
            return dualityType.equals(DualityType.YIN);
        } else {
            return dualityType.equals(DualityType.YANG);
        }
    }

    // when a fate cycle has influence over a lunar method, for the first 5 years of the fate cycle the stem has an effect, with the branch being used instead after that
    public boolean isUseStem(int activeFateCycleAge, LocalDate dob, LocalDate currentDate) {
        int currentAge = Period.between(dob, currentDate).getYears();

        // when a person is really young they might be younger then when their first fate cycle is meant to start.
        if (currentAge < activeFateCycleAge) {
            currentAge = activeFateCycleAge;
        }
        return currentAge - activeFateCycleAge < 5;
    }
}

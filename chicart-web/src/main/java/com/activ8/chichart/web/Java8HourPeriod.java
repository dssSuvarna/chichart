package com.activ8.chichart.web;

import com.activ8.chichart.constant.*;

import java.time.*;

public class Java8HourPeriod {
    private HourPeriod hourPeriod;

    public Java8HourPeriod(HourPeriod hourPeriod) {
        this.hourPeriod = hourPeriod;
    }

    public String getLabel() {
        return hourPeriod.getLabel();
    }

    public LocalTime getTime() {
        return hourPeriod.getTime();
    }
}

package com.activ8.chichart.core.service;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;

import java.time.*;

public class LunarMethodCommand {

    private FourPillarsChart chart;
    private LocalDate dob;
    private Gender gender;
    private LocalDate calendarDate;

    public LunarMethodCommand(FourPillarsChart chart, LocalDate dob, Gender gender, LocalDate calendarDate) {
        this.chart = chart;
        this.dob = dob;
        this.gender = gender;
        this.calendarDate = calendarDate;
    }

    public FourPillarsChart getChart() {
        return chart;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getCalendarDate() {
        return calendarDate;
    }
}

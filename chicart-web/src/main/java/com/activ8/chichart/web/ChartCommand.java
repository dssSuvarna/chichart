package com.activ8.chichart.web;

import com.activ8.chichart.constant.*;
import org.springframework.format.annotation.*;

import java.time.*;

public class ChartCommand {

    private Integer day;
    private Integer month;
    private Integer year;
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate calendarMonth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate calendarYear;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getDob() {
        return LocalDate.of(year, month, day);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getCalendarMonth() {
        return calendarMonth;
    }

    public void setCalendarMonth(LocalDate calendarMonth) {
        this.calendarMonth = calendarMonth;
    }

    public LocalDate getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(LocalDate calendarYear) {
        this.calendarYear = calendarYear;
    }
}

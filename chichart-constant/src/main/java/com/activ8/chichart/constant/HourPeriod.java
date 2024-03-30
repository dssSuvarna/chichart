package com.activ8.chichart.constant;

import java.time.*;

public enum HourPeriod {

    TIME_12AM_1AM(LocalTime.of(0, 0), "12am - 1am"),
    TIME_1AM_2AM(LocalTime.of(1, 0), "1am - 2am"),
    TIME_2AM_3AM(LocalTime.of(2, 0), "2am - 3am"),
    TIME_3AM_4AM(LocalTime.of(3, 0), "3am - 4am"),
    TIME_4AM_5AM(LocalTime.of(4, 0), "4am - 5am"),
    TIME_5AM_6AM(LocalTime.of(5, 0), "5am - 6am"),
    TIME_6AM_7AM(LocalTime.of(6, 0), "6am - 7am"),
    TIME_7AM_8AM(LocalTime.of(7, 0), "7am - 8am"),
    TIME_8AM_9AM(LocalTime.of(8, 0), "8am - 9am"),
    TIME_9AM_10AM(LocalTime.of(9, 0), "9am - 10am"),
    TIME_10AM_11AM(LocalTime.of(10, 0), "10am - 11am"),
    TIME_11AM_12PM(LocalTime.of(11, 0), "11am - 12pm"),
    TIME_12PM_1PM(LocalTime.of(12, 0), "12pm - 1pm"),
    TIME_1PM_2PM(LocalTime.of(13, 0), "1pm - 2pm"),
    TIME_2PM_3PM(LocalTime.of(14, 0), "2pm - 3pm"),
    TIME_3PM_4PM(LocalTime.of(15, 0), "3pm - 4pm"),
    TIME_4PM_5PM(LocalTime.of(16, 0), "4pm - 5m"),
    TIME_5PM_6PM(LocalTime.of(17, 0), "5pm - 6pm"),
    TIME_6PM_7PM(LocalTime.of(18, 0), "6pm - 7pm"),
    TIME_7PM_8PM(LocalTime.of(19, 0), "7pm - 8pm"),
    TIME_8PM_9PM(LocalTime.of(20, 0), "8pm - 9pm"),
    TIME_9PM_10PM(LocalTime.of(21, 0), "9pm - 10pm"),
    TIME_10PM_11PM(LocalTime.of(22, 0), "10pm - 11pm"),
    TIME_11PM_12AM(LocalTime.of(23, 0), "11pm - 12am");


    private LocalTime time;
    private String label;

    HourPeriod(LocalTime time, String label) {
        this.time = time;
        this.label = label;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getLabel() {
        return label;
    }

}
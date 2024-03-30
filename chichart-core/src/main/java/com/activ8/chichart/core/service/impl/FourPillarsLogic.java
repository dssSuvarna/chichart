package com.activ8.chichart.core.service.impl;


import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.ibm.icu.util.*;

import java.time.*;

import static java.time.temporal.ChronoUnit.*;

public class FourPillarsLogic {

    private ChineseCalendar chineseCalendar;

    private JaiZiCycle jaiZiCycle;

    private HourPillarLogic hourPillarLogic;

    private YearMonthStemMapping yearMonthStemMapping = new YearMonthStemMapping();

    private PillarProvider pillarProvider;

    public FourPillarsLogic(ChineseCalendar chineseCalendar, JaiZiCycle jaiZiCycle, HourPillarLogic hourPillarLogic, PillarProvider pillarProvider) {
        this.chineseCalendar = chineseCalendar;
        this.jaiZiCycle = jaiZiCycle;
        this.hourPillarLogic = hourPillarLogic;
        this.pillarProvider = pillarProvider;
    }

    public Pillar getYear(LocalDate date) {
        return getPeriod(date, ChineseCalendar.YEAR);
    }

    public Pillar getDay(LocalDate date) {
        return getDay(date, null);
    }

    // Hope this works!
    // http://www.drweichiehyoung.com/academic-discussions/2014/9/8/5-would-you-please-teach-me-the-quick-method-to-calculate-the-gan-zhi-heavenly-stems-and-earthly-branches-of-the-day-and-shichen
    public Pillar getDay(LocalDate date, LocalTime time) {

        if (time != null && hourPillarLogic.isDayPillarNextDay(time)) {
            date = date.plusDays(1);
        }

        LocalDate firstDayOfYear = date.withDayOfYear(1);
        long dayOfYear = DAYS.between(firstDayOfYear, date) + 1;

        //long dayOfYear = Days.daysBetween(firstDayOfYear, date).getDays() + 1;

        // StemType: 〔5(x-1)+((x-1)/4)r+15+y〕/10
        // BranchType: 〔5(x-1)+((x-1)/4)r+15+y〕/12
        int yearTwoDigit = (date.getYear() % 100);
        if (date.getYear() >= 2000) yearTwoDigit = yearTwoDigit + 100;
        Long dayCalc = (5 * (yearTwoDigit - 1) + ((yearTwoDigit - 1) / 4) + 15 + dayOfYear);

        int stem = (dayCalc.intValue() % 10) - 1;
        if (stem == -1) {
            stem = 9;
        }

        int branch = (dayCalc.intValue() % 12) - 1;
        if (branch == -1) {
            branch = 11;
        }

        return pillarProvider.createPillar(PillarType.DAY, StemType.values()[stem], BranchType.values()[branch]);
    }

    private Pillar getPeriod(LocalDate date, int period) {
        chineseCalendar.setTime(DateUtils.asDate(date));
        int index = chineseCalendar.get(period);
        return jaiZiCycle.getSequence(index);
    }

    /*
    For general calcs, see See http://www.hko.gov.hk/gts/time/stemsandbranches.htm

    Leap month calculations need to be adjusted. First 15 days becomes the month before, the last 15 days becomes the following month.
    Eg leap month in July/August 2017. Starts 23/7/17, finishes 21/8/17. From 23/7 to 6/8 is month before Ding Wei, 7/8 to 21/8 is Wu Shen.

    */
    public Pillar getMonth(LocalDate date) {
        Pillar yearSequence = getYear(date);
        int month = chineseCalendar.get(ChineseCalendar.MONTH); // month is 0 based

        // Note: It looks like the ChineseCalendar class treats the entire leap month as the previous month and doesn't split it 50/50
        if (isSecondHalfOfLeapMonth(date)) {
            month++;
        }

        Integer month1Stem = yearMonthStemMapping.getStemMonth(yearSequence.getStemType());
        int monthStem = (month1Stem + month);
        if (monthStem > 10) {
            monthStem = monthStem - 10;
        }

        Integer month1Branch = 3;
        int monthBranch = (month1Branch + month);
        if (monthBranch > 12) {
            monthBranch = monthBranch - 12;
        }

        return pillarProvider.createPillar(PillarType.MONTH, StemType.values()[monthStem - 1], BranchType.values()[monthBranch - 1]);
    }

    public Pillar getHour(LocalTime time, StemType dayStemType) {
        Pillar pillar = hourPillarLogic.getPillar(time, dayStemType);
        return pillarProvider.createPillar(PillarType.HOUR, pillar.getStemType(), pillar.getBranchType(), pillar.isUseStem());
    }

    private boolean isLeapMonth(LocalDate date) {
        chineseCalendar.setTime(DateUtils.asDate(date));
        return chineseCalendar.get(ChineseCalendar.IS_LEAP_MONTH) == 1;
    }

    private boolean isSecondHalfOfLeapMonth(LocalDate date) {
        return isLeapMonth(date) && getDaysUntilLeapMonthOver(date) <= 15;
    }

    private int getDaysUntilLeapMonthOver(LocalDate date) {
        int days = 0;
        while (isLeapMonth(date)) {
            date = date.plusDays(1);
            days++;
        }
        return days;
    }
}

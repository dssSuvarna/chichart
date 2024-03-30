package com.activ8.chichart.core.service.month;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.impl.*;
import com.activ8.chichart.core.service.rulers.*;

import java.time.*;
import java.util.*;

public class CalendarServiceImpl implements CalendarService {

    private FourPillarsLogic fourPillarsLogic;

    private LunarMethodService lunarMethodService;

    private BranchClashLogic branchClashLogic;

    private TwelveRulersLogic twelveRulersLogic;

    public CalendarServiceImpl(FourPillarsLogic fourPillarsLogic, LunarMethodService lunarMethodService, BranchClashLogic branchClashLogic, TwelveRulersLogic twelveRulersLogic) {
        this.fourPillarsLogic = fourPillarsLogic;
        this.lunarMethodService = lunarMethodService;
        this.branchClashLogic = branchClashLogic;
        this.twelveRulersLogic = twelveRulersLogic;
    }

    @Override
    public List<CalendarDay> getCalendarDays(CalendarData calendarData, LocalDate startDate, LocalDate endDate, LocalDate dob, Gender gender) {

        List<CalendarDay> days = new ArrayList<>();

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {

            LunarMethodCommand lunarMethodCommand = new LunarMethodCommand(calendarData.getChart(), dob, gender, LocalDate.now());
            FourPillarsChart dayChart = new FourPillarsChart(fourPillarsLogic.getDay(date, null), fourPillarsLogic.getMonth(date), fourPillarsLogic.getYear(date));

            CalendarDay day = new CalendarDay(date, dayChart.getDayPillar(), dayChart.getMonthPillar(), dayChart.getYearPillar(), lunarMethodService.getLunarMethod(lunarMethodCommand),
                    branchClashLogic.isMonthBreaker(dayChart), branchClashLogic.isYearBreaker(dayChart),
                    twelveRulersLogic.getRuler(dayChart.getMonthPillar().getBranchType(), dayChart.getDayPillar().getBranchType()));

            for (HourPeriod hourPeriod : HourPeriod.values()) {
                Pillar hour = fourPillarsLogic.getHour(hourPeriod.getTime(), dayChart.getDayPillar().getStemType());
                day.addRankedHour(hourPeriod, calendarData.getRankedStem(hour.getStemType()), calendarData.getRankedBranch(hour.getBranchType()), hour.isUseStem());
            }

            days.add(day);
        }

        return days;

    }
}

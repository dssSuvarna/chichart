package com.activ8.chichart.web.controller;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.chisymbol.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.month.*;
import com.activ8.chichart.core.service.snippet.*;
import com.activ8.chichart.web.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

import static java.time.temporal.TemporalAdjusters.*;

@Controller
public class ChartController {

    private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

    private FateCycleService fateCycleService = ServiceFactory.getInstance().getFateCycleService();

    private LunarMethodService lunarMethodService = ServiceFactory.getInstance().getLunarMethodService();

    private CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();

    private SnippetService snippetService = ServiceFactory.getInstance().getSnippetService();

    private ChiSymbolService chiSymbolService = ServiceFactory.getInstance().getChiSymbolService();

    @RequestMapping(path = "/chart", method = RequestMethod.GET)
    public String showForm(Model model) {
        ChartCommand chartCommand = new ChartCommand();
        chartCommand.setCalendarMonth(LocalDate.now().with(firstDayOfMonth()));
        chartCommand.setCalendarYear(LocalDate.now().with(firstDayOfYear()));
        chartCommand.setGender(Gender.MALE);
        chartCommand.setDay(26);
        chartCommand.setMonth(7);
        chartCommand.setYear(1939);
        chartCommand.setTime(HourPeriod.TIME_2AM_3AM.getTime());

        model.addAttribute("chartCommand", chartCommand);
        return "chart-form";
    }

    @RequestMapping(path = "/chart", method = RequestMethod.POST)
    public String chart(@ModelAttribute ChartCommand chartCommand, Model model) {

        LocalDate dob = chartCommand.getDob();

        LocalDate chartDate = LocalDate.of(chartCommand.getCalendarYear().getYear(), chartCommand.getCalendarMonth().getMonth(), 1);

        FourPillarsChart chart = fourPillarsService.getPillars(dob, chartCommand.getTime());
        model.addAttribute("chart", chart);
        model.addAttribute("hourPillar", chart.getHourPillar());
        model.addAttribute("yearPillar", chart.getYearPillar());
        model.addAttribute("monthPillar", chart.getMonthPillar());
        model.addAttribute("dayPillar", chart.getDayPillar());

        Stem yearStem = chart.getYearPillar().getStem();
        List<FateCycle> fateCycles = fateCycleService.getFateCycles(dob, chartCommand.getGender(), yearStem.getDuality().getType());
        model.addAttribute("fateCycles", fateCycles);
        model.addAttribute("activeFateCycle", fateCycleService.getActiveFateCycle(dob, chartDate, fateCycles));
        model.addAttribute("chartCommand", chartCommand);

        LunarMethod lunarMethod = lunarMethodService.getLunarMethod(new LunarMethodCommand(chart, dob, chartCommand.getGender(), chartDate));

        model.addAttribute("lunarMethod", lunarMethod.getName(chart));
        model.addAttribute("lunarMethodElements", lunarMethodService.getRankedElements(lunarMethod.getType(), chart.getDayPillar().getStem().getElement()));

        CalendarData calendarData = new CalendarData(chart,
                lunarMethodService.getRankedStems(chart, lunarMethod, chart.getDayPillar().getStem().getElement()),
                lunarMethodService.getRankedBranches(chart, lunarMethod, chart.getDayPillar().getStem().getElement()));

        List<CalendarDay> calendarDays = calendarService.getCalendarDays(calendarData, chartDate, YearMonth.from(chartDate).atEndOfMonth(), dob, chartCommand.getGender());
        snippetService.injectSnippets(lunarMethod.getType(), chart.getDayPillar().getStemType(), calendarDays);
        chiSymbolService.injectChiSymbols(chart, calendarDays);

        model.addAttribute("calendarDays", calendarDays);
        model.addAttribute("calendarData", calendarData);
        return "chart-list";
    }

    @ModelAttribute(name = "hours")
    public List<Java8HourPeriod> getHours() {
        return Arrays.stream(HourPeriod.values())
                .map(Java8HourPeriod::new)
                .collect(Collectors.toList());
    }

    @ModelAttribute(name = "calendarMonths")
    public List<LocalDate> getCalendarMonths() {

        LocalDate firstDay = LocalDate.now().with(firstDayOfYear());
        List<LocalDate> dates = new ArrayList<>();
        LocalDate date = firstDay;
        for (int i = 0 ; i < 12; i++) {
            dates.add(date);
            date = date.plusMonths(1);
        }

        return dates;
    }

    @ModelAttribute(name = "calendarYears")
    public List<LocalDate> getCalendarYears() {

        LocalDate firstDay = LocalDate.of(1900, 1, 1);
        LocalDate lastDay = LocalDate.now().with(firstDayOfYear()).plusYears(50);
        List<LocalDate> dates = new ArrayList<>();

        for (LocalDate date = firstDay; date.isBefore(lastDay); date = date.plusYears(1)) {
            dates.add(date);
        }

        return dates;
    }

}
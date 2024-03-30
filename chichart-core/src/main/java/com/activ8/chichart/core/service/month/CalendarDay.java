package com.activ8.chichart.core.service.month;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.chisymbol.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;
import com.activ8.chichart.core.service.rulers.*;

import java.time.*;
import java.util.*;

public class CalendarDay {

    private LocalDate date;
    private Pillar dayPillar;
    private Pillar monthPillar;
    private Pillar yearPillar;
    private Snippet snippet;
    private ChiSymbolDetails chiSymbolDetails;
    private LunarMethod lunarMethod;
    private Ruler ruler;
    private boolean monthBreaker;
    private boolean yearBreaker;
    private String pillarCharacteristics;

    private List<CalendarHourPeriod> calendarHourPeriods = new ArrayList<>();

    public CalendarDay(LocalDate date, Pillar dayPillar, Pillar monthPillar, Pillar yearPillar, LunarMethod lunarMethod, boolean monthBreaker, boolean yearBreaker, Ruler ruler) {
        this.date = date;
        this.dayPillar = dayPillar;
        this.monthPillar = monthPillar;
        this.yearPillar = yearPillar;
        this.lunarMethod = lunarMethod;
        this.monthBreaker = monthBreaker;
        this.yearBreaker = yearBreaker;
        this.ruler = ruler;
    }

    public LocalDate getDate() {
        return date;
    }

    public Pillar getDayPillar() {
        return dayPillar;
    }

    public Pillar getMonthPillar() {
        return monthPillar;
    }

    public Pillar getYearPillar() {
        return yearPillar;
    }

    public List<CalendarHourPeriod> getCalendarHourPeriods() {
        return calendarHourPeriods;
    }

    public LunarMethod getLunarMethod() {
        return lunarMethod;
    }

    public void addRankedHour(HourPeriod hourPeriod, RankedStem rankedStem, RankedBranch rankedBranch, boolean useStem) {
        calendarHourPeriods.add(new CalendarHourPeriod(hourPeriod, rankedStem, rankedBranch, useStem));
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public ChiSymbolDetails getChiSymbolDetails() {
        return chiSymbolDetails;
    }

    public void setChiSymbolDetails(ChiSymbolDetails chiSymbolDetails) {
        this.chiSymbolDetails = chiSymbolDetails;
    }

    public boolean isMonthBreaker() {
        return monthBreaker;
    }

    public boolean isYearBreaker() {
        return yearBreaker;
    }

    public Ruler getRuler() {
        return ruler;
    }

    public String getPillarCharacteristics() {
        return pillarCharacteristics;
    }

    public void setPillarCharacteristics(String pillarCharacteristics) {
        this.pillarCharacteristics = pillarCharacteristics;
    }

    @Override
    public String toString() {
        return "CalendarDay{" +
                "date=" + date +
                ", dayPillar=" + dayPillar +
                ", monthPillar=" + monthPillar +
                ", yearPillar=" + yearPillar +
                ", snippet=" + snippet +
                ", chiSymbolDetails=" + chiSymbolDetails +
                ", lunarMethod=" + lunarMethod +
                ", monthBreaker=" + monthBreaker +
                ", yearBreaker=" + yearBreaker +
                ", ruler=" + ruler +
                ", pillarCharacteristics=" + pillarCharacteristics +
                '}';
    }
}

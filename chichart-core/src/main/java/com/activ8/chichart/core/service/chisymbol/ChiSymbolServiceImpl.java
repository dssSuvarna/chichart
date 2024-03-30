package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.impl.*;
import com.activ8.chichart.core.service.month.*;
import com.activ8.chichart.core.service.snippet.*;

import java.util.*;

public class ChiSymbolServiceImpl implements ChiSymbolService {

    private SnippetCodeChiSymbolProvider snippetCodeChiSymbolProvider = new SnippetCodeChiSymbolProvider();
    private RomanceSymbolLogic romanceSymbolLogic = new RomanceSymbolLogic();
    private BranchClashLogic branchClashLogic = new BranchClashLogic();
    private AcademicSymbolLogic academicSymbolLogic = new AcademicSymbolLogic();
    private TravelSymbolLogic travelSymbolLogic = new TravelSymbolLogic();
    private CelebrationSymbolLogic celebrationSymbolLogic = new CelebrationSymbolLogic();
    private ChiSymbolDetailsProvider chiSymbolSnippetDescriptionProvider = new ChiSymbolDetailsProvider();

    @Override
    public ChiSymbolDetails getChiSymbolDetails(FourPillarsChart chart, CalendarDay calendarDay) {

        if (isTravel(chart, calendarDay)) {
            return chiSymbolSnippetDescriptionProvider.getTravel();
        } else if (isAcademic(chart, calendarDay)) {
            return chiSymbolSnippetDescriptionProvider.getAcademic();
        } else if (isCelebration(chart, calendarDay)) {
            return chiSymbolSnippetDescriptionProvider.getCelebration();
        } else if (isHealth(chart, calendarDay)) {
            return chiSymbolSnippetDescriptionProvider.getHealth();
        } else if (isRomance(chart, calendarDay)) {
            return chiSymbolSnippetDescriptionProvider.getRomance();
        } else {
            return chiSymbolSnippetDescriptionProvider.getDescription(calendarDay.getSnippet().getBranchCode());
        }
    }

    @Override
    public void injectChiSymbols(FourPillarsChart chart, List<CalendarDay> calendarDays) {
        for (CalendarDay calendarDay : calendarDays) {
            calendarDay.setChiSymbolDetails(getChiSymbolDetails(chart, calendarDay));
        }
    }

    private boolean isRomance(FourPillarsChart chart, CalendarDay calendarDay) {
        return romanceSymbolLogic.matches(chart.getDayPillar().getBranchType(), calendarDay.getDayPillar().getBranchType());
    }

    /**
     * If the person’s Day OR Month Branch clashes with the current day branch (see 01 The Stems and Branches 14_07_2018.xlsx in the Branch Designations tab in the Clashes column)
     * then use the Health Symbol, each one will get 2 per month unless a special symbol over-rules.
     */
    private boolean isHealth(FourPillarsChart chart, CalendarDay calendarDay) {
        final BranchType chartDayBranch = chart.getDayPillar().getBranchType();
        final BranchType chartMonthBranch = chart.getMonthPillar().getBranchType();
        final BranchType currentDayBranch = calendarDay.getDayPillar().getBranchType();

        return branchClashLogic.getClash(chartDayBranch) == currentDayBranch || branchClashLogic.getClash(chartMonthBranch) == currentDayBranch;
    }

    private boolean isAcademic(FourPillarsChart chart, CalendarDay calendarDay) {
        return academicSymbolLogic.matches(chart.getDayPillar().getStemType(), calendarDay.getDayPillar().getBranchType());
    }

    private boolean isTravel(FourPillarsChart chart, CalendarDay calendarDay) {
        return travelSymbolLogic.matches(chart.getDayPillar().getBranchType(), calendarDay.getDayPillar().getBranchType());
    }

    private boolean isCelebration(FourPillarsChart chart, CalendarDay calendarDay) {
        return celebrationSymbolLogic.matches(chart.getDayPillar().getBranchType(), calendarDay.getDayPillar().getBranchType());
    }

}

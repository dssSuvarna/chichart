package com.activ8.chichart.core.service.calendar;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;
import com.activ8.chichart.core.service.month.*;
import org.junit.*;

import java.time.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class JohnHoward extends AbstractUnitTest {

    private ElementRankLogic elementRankLogic = ServiceFactory.getInstance().getElementRankLogic();

    private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

    private LunarMethodService lunarMethodService = ServiceFactory.getInstance().getLunarMethodService();

    private CalendarService calendarService = ServiceFactory.getInstance().getCalendarService();

    @Test
    public void august2016() {

        LocalDate dob = LocalDate.of(1939, 7, 26);
        FourPillarsChart chart = fourPillarsService.getPillars(dob, LocalTime.of(2,21));
        LunarMethod lunarMethod = lunarMethodService.getLunarMethod(new LunarMethodCommand(chart, dob, Gender.MALE, LocalDate.now()));
        List<ElementType> rankedElements = lunarMethodService.getRankedElements(lunarMethod.getType(), chart.getDayPillar().getStem().getElement());
        List<RankedStem> rankedStems = elementRankLogic.rankStems(chart, lunarMethod, rankedElements);
        List<RankedBranch> rankedBranches = elementRankLogic.rankBranches(chart, lunarMethod, rankedElements);

        CalendarData calendarData = new CalendarData(chart, rankedStems, rankedBranches);

        List<CalendarDay> calendarDays = calendarService.getCalendarDays(calendarData, LocalDate.of(2016, 8, 1), LocalDate.of(2016, 8, 31), dob, Gender.MALE);

        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_11PM_12AM, StemType.BING, BranchType.ZI);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_1AM_2AM, StemType.DING, BranchType.CHOU);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_3AM_4AM, StemType.WU, BranchType.YIN);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_5AM_6AM, StemType.JI, BranchType.MAO);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_7AM_8AM, StemType.GENG, BranchType.CHEN);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_9AM_10AM, StemType.XIN, BranchType.SI);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_11AM_12PM, StemType.REN, BranchType.WU);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_1PM_2PM, StemType.GUI, BranchType.WEI);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_3PM_4PM, StemType.JIA, BranchType.SHEN);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_5PM_6PM, StemType.YI, BranchType.YOU);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_7PM_8PM, StemType.BING, BranchType.XU);
        assertHourPeriod(calendarDays, LocalDate.of(2016, 8, 1), HourPeriod.TIME_9PM_10PM, StemType.DING, BranchType.HAI);
    }

    private void assertHourPeriod(List<CalendarDay> calendarDays, LocalDate date, HourPeriod hourPeriod, StemType stemType, BranchType branchType) {
        CalendarDay calendarDay = null;
        for (CalendarDay cd : calendarDays) {
            if (cd.getDate().equals(date)) {
                calendarDay = cd;
                break;
            }
        }

        if (calendarDay == null) {
            throw new RuntimeException("Could not find entry for " + date);
        }

        CalendarHourPeriod calendarHourPeriod = null;
        for (CalendarHourPeriod chp : calendarDay.getCalendarHourPeriods()) {
            if (chp.getHourPeriod() == hourPeriod) {
                calendarHourPeriod = chp;
                break;
            }
        }

        if (calendarHourPeriod == null) {
            throw new RuntimeException("Could not find entry for " + hourPeriod);
        }

        assertThat(calendarHourPeriod.getRankedStem().getStemType()).isEqualTo(stemType);
        assertThat(calendarHourPeriod.getRankedBranch().getBranchType()).isEqualTo(branchType);
    }
}

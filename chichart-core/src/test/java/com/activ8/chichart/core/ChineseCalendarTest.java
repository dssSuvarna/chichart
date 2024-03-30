package com.activ8.chichart.core;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.*;
import org.junit.*;
import org.slf4j.*;

import java.time.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ChineseCalendarTest {

    private Logger logger = LoggerFactory.getLogger(ChineseCalendarTest.class);

    @Test
    public void test() {

        ChineseCalendar calendar = createCalendar(DateUtils.asDate(LocalDate.of(1971, 11, 23))); // 23-11-1971

        logger.info("ERA: " + calendar.get(ChineseCalendar.ERA));
        logger.info("YEAR: " + calendar.get(ChineseCalendar.YEAR));
        logger.info("MONTH: " + calendar.get(ChineseCalendar.MONTH));
        logger.info("DAY: " + calendar.get(ChineseCalendar.DAY_OF_WEEK));

    }

    @Test
    public void test2() {
        createCalendar(DateUtils.asDate(LocalDate.of(2005, 2, 1))); // 1-03-2005
    }

    @Test
    public void testLeapMonth() {
        ChineseCalendar calendar = createCalendar(DateUtils.asDate(LocalDate.of(2017, 7, 23)));
        assertThat(calendar.get(Calendar.IS_LEAP_MONTH)).isEqualTo(1);
    }

    private ChineseCalendar createCalendar(Date date) {
        ULocale locale = new ULocale("en_AU@calendar=chinese");
        ChineseCalendar calendar = (ChineseCalendar) Calendar.getInstance(locale);

        logger.info(date.toString());
        calendar.setTime(date);
        logger.info(calendar.getTime().toString());

        return calendar;
    }
}

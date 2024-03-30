package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import org.junit.*;
import org.slf4j.*;

import java.time.*;
import java.util.*;

public class LunarMethodCoverageTest extends AbstractUnitTest {

    private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

    private LunarMethodService lunarMethodService = ServiceFactory.getInstance().getLunarMethodService();

    private Logger logger = LoggerFactory.getLogger(LunarMethodCoverageTest.class);

    @Test
    public void fourPillarsTest() {


        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.now();
        Map<String,Integer> counts = new HashMap<>();
        LocalDate date = startDate;

        while (date.isBefore(endDate)) {
            FourPillarsChart chart = fourPillarsService.getPillars(date, LocalTime.of(1,0));
            LunarMethod lunarMethod = lunarMethodService.getLunarMethod(new LunarMethodCommand(chart, date, Gender.MALE, LocalDate.now()));
            String chartType = lunarMethod.getName(chart);
            increment(chartType, counts);

            date = date.plusDays(1);
        }

        for (String chartType : counts.keySet()) {
            logger.debug(String.format("%s %d", chartType, counts.get(chartType)));
        }

    }

    private void increment(String chartType, Map<String,Integer> counts) {
        Integer count = counts.get(chartType);
        if (count == null) {
            count = 0;
        }
        count++;
        counts.put(chartType, count);
    }
}
package com.activ8.chichart.core.service.characteristics;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.month.*;

import java.util.*;

public class PillarCharacteristicsServiceImpl implements PillarCharacteristicsService {

   final private PillarCharacteristicsProvider pillarCharacteristicsProvider = new PillarCharacteristicsProvider();

    @Override
    public void injectCharacteristics(Pillar pillar, List<CalendarDay> calendarDays) {
        for (CalendarDay calendarDay : calendarDays) {
            calendarDay.setPillarCharacteristics(getDescription(calendarDay.getDayPillar()));
        }

    }

    private String getDescription(Pillar pillar) {
        return pillarCharacteristicsProvider.getDescription(pillar);
    }
}

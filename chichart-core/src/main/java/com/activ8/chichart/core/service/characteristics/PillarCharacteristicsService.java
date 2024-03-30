package com.activ8.chichart.core.service.characteristics;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.month.*;

import java.util.*;

public interface PillarCharacteristicsService {
    void injectCharacteristics(Pillar pillar, List<CalendarDay> calendarDays);
}

package com.activ8.chichart.api.rest.resource;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.month.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartResource {
    FourPillarsChart chart;
    List<FateCycle> fateCycles;
    FateCycle activeFateCycle;
    LunarMethod lunarMethod;

    List<ElementType> rankedElements;

    CalendarData calendarData;
    List<CalendarDay> calendarDays;
}

package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.month.*;

import java.util.*;

public interface ChiSymbolService {
    ChiSymbolDetails getChiSymbolDetails(FourPillarsChart chart, CalendarDay calendarDay);
    void injectChiSymbols(FourPillarsChart chart, List<CalendarDay> calendarDays);
}

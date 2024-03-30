package com.activ8.chichart.core.service.month;

import com.activ8.chichart.constant.*;

import java.time.*;
import java.util.*;

public interface CalendarService {
    List<CalendarDay> getCalendarDays(CalendarData calendarData, LocalDate startDate, LocalDate endDate, LocalDate dob, Gender gender);
}

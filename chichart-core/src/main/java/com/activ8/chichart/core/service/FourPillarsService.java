package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;

import java.time.*;

public interface FourPillarsService {

    FourPillarsChart getPillars(LocalDate date, LocalTime time);

    FourPillarsChart getPillars(LocalDate date);
}

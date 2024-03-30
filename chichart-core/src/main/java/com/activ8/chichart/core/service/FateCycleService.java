package com.activ8.chichart.core.service;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;

import java.time.*;
import java.util.*;

public interface FateCycleService {
    List<FateCycle> getFateCycles(LocalDate date, Gender gender, DualityType dualityType);
    FateCycle getActiveFateCycle(LocalDate dob, LocalDate date, List<FateCycle> fateCycles);
}

package com.activ8.chichart.core.service;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import org.junit.*;

import java.time.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class FateCycleServiceTest extends AbstractUnitTest {

    private FateCycleService fateCycleService = ServiceFactory.getInstance().getFateCycleService();

    @Test
    public void fatecycle_test() {
        fatecycle(LocalDate.of(1970, 7, 15), Gender.FEMALE, DualityType.YANG, 2);
    }

    private void fatecycle(LocalDate date, Gender gender, DualityType dualityType, Integer expectedAge) {
        List<FateCycle> results = fateCycleService.getFateCycles(date, gender, dualityType);
        //assertThat(age).isEqualTo(expectedAge);
    }

    @Test
    public void currentFateCycle_JohnHoward() {

        LocalDate dob = LocalDate.of(1939, 7, 26);

        List<FateCycle> fateCycles = fateCycleService.getFateCycles(dob, Gender.MALE, DualityType.YIN);

        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(1939, 8, 1), fateCycles).getAge()).isEqualTo(6);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(1945, 8, 1), fateCycles).getAge()).isEqualTo(6);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(1951, 8, 1), fateCycles).getAge()).isEqualTo(6);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(1961, 8, 1), fateCycles).getAge()).isEqualTo(16);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(1971, 8, 1), fateCycles).getAge()).isEqualTo(26);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(2016, 8, 1), fateCycles).getAge()).isEqualTo(76);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(2020, 8, 1), fateCycles).getAge()).isEqualTo(76);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(2025, 8, 1), fateCycles).getAge()).isEqualTo(86);
        assertThat(fateCycleService.getActiveFateCycle(dob, LocalDate.of(2040, 8, 1), fateCycles).getAge()).isEqualTo(96);
    }
}
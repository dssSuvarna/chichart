package com.activ8.chichart.core.service;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.impl.*;
import org.junit.*;

import java.time.*;

import static org.assertj.core.api.Assertions.*;

public class FateCycleLogicTest extends AbstractUnitTest {

    private FateCycleLogic fateCycleLogic = new FateCycleLogic(getDataService());

    @Test
    public void fatecycle_test() {
        fatecycle(LocalDate.of(1970, 7, 15), Gender.FEMALE, DualityType.YANG, 2);
    }

    @Test
    public void isUseStem() {
        LocalDate DOB = LocalDate.of(2000, 1, 1);
        // age 1
        assertThat(fateCycleLogic.isUseStem(7, DOB , LocalDate.of(2001, 2, 2))).isTrue();

        // age 6
        assertThat(fateCycleLogic.isUseStem(7, DOB , LocalDate.of(2006, 2, 2))).isTrue();

        // age 11
        assertThat(fateCycleLogic.isUseStem(7, DOB , LocalDate.of(2011, 2, 2))).isTrue();

        // age 14
        assertThat(fateCycleLogic.isUseStem(7, DOB , LocalDate.of(2014, 2, 2))).isFalse();

        // age 16
        assertThat(fateCycleLogic.isUseStem(7, DOB , LocalDate.of(2016, 2, 2))).isFalse();

        // age 19
        assertThat(fateCycleLogic.isUseStem(17, DOB , LocalDate.of(2019, 2, 2))).isTrue();
    }

    private void fatecycle(LocalDate date, Gender gender, DualityType dualityType, Integer expectedAge) {
        Integer age = fateCycleLogic.getFateCycleStartAge(date, gender, dualityType);
        assertThat(age).isEqualTo(expectedAge);
    }

}
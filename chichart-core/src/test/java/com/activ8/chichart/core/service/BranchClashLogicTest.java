package com.activ8.chichart.core.service;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.impl.*;
import org.junit.*;

import java.time.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class BranchClashLogicTest extends AbstractUnitTest {

    private BranchClashLogic branchClashLogic = ServiceFactory.getInstance().getBranchClashLogic();
    private FourPillarsLogic fourPillarsLogic = ServiceFactory.getInstance().getFourPillarsLogic();

    @Test
    public void yearBreaker_20180406() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 4, 6));
        assertThat(branchClashLogic.isYearBreaker(chart)).isTrue();
    }

    @Test
    public void yearBreaker_20180418() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 4, 18));
        assertThat(branchClashLogic.isYearBreaker(chart)).isTrue();
    }

    @Test
    public void yearBreaker_20180430() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 4, 30));
        assertThat(branchClashLogic.isYearBreaker(chart)).isTrue();
    }

    @Test
    public void monthBreaker_20180411() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 4, 11));
        assertThat(branchClashLogic.isMonthBreaker(chart)).isTrue();
    }

    @Test
    public void monthBreaker_20180424() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 4, 24));
        assertThat(branchClashLogic.isMonthBreaker(chart)).isTrue();
    }

    @Test
    public void monthBreaker_20180506() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 5, 6));
        assertThat(branchClashLogic.isMonthBreaker(chart)).isTrue();
    }

    @Test
    public void monthBreaker_20180507_notBreaker() {
        FourPillarsChart chart = createChart(LocalDate.of(2018, 5, 7));
        assertThat(branchClashLogic.isMonthBreaker(chart)).isFalse();
    }

    private FourPillarsChart createChart(LocalDate date) {
        Map<PillarType, Pillar> pillars = new HashMap<>();
        pillars.put(PillarType.DAY, fourPillarsLogic.getDay(date, null));
        pillars.put(PillarType.MONTH, fourPillarsLogic.getMonth(date));
        pillars.put(PillarType.YEAR, fourPillarsLogic.getYear(date));

        return new FourPillarsChart(pillars);
    }
}

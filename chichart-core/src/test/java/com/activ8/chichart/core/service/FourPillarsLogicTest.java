package com.activ8.chichart.core.service;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.impl.*;
import org.junit.*;

import java.time.*;

import static org.assertj.core.api.Assertions.*;


public class FourPillarsLogicTest extends AbstractUnitTest {

    private FourPillarsLogic fourPillarsLogic = ServiceFactory.getInstance().getFourPillarsLogic();

    @Test
    public void testYearPillars() {

        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1955, 7, 7)), StemType.YI, BranchType.WEI);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1960, 12, 25)), StemType.GENG, BranchType.ZI);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1981, 6, 5)), StemType.XIN, BranchType.YOU);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1985, 9, 22)), StemType.YI, BranchType.CHOU);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1989, 1, 1)), StemType.WU, BranchType.CHEN);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1992, 1, 28)), StemType.XIN, BranchType.WEI);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(1999, 12, 31)), StemType.JI, BranchType.MAO);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(2000, 11, 11)), StemType.GENG, BranchType.CHEN);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(2010, 3, 3)), StemType.GENG, BranchType.YIN);
        assertPillar(fourPillarsLogic.getYear(LocalDate.of(2016, 8, 20)), StemType.BING, BranchType.SHEN);
    }

    @Test
    public void testMonthPillars() {

        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1955, 7, 7)), StemType.REN, BranchType.WU);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1960, 12, 25)), StemType.WU, BranchType.ZI);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1981, 6, 5)), StemType.JIA, BranchType.WU);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1985, 9, 22)), StemType.YI, BranchType.YOU);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1989, 1, 1)), StemType.JIA, BranchType.ZI);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1992, 1, 28)), StemType.XIN, BranchType.CHOU);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(1999, 12, 31)), StemType.BING, BranchType.ZI);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2000, 11, 11)), StemType.DING, BranchType.HAI);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2010, 3, 3)), StemType.WU, BranchType.YIN);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2016, 8, 20)), StemType.BING, BranchType.SHEN);

    }

    @Test
    public void testDayPillars() {

        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1955, 7, 7)), StemType.JI, BranchType.SI);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1960, 12, 25)), StemType.DING, BranchType.HAI);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1981, 6, 5)), StemType.JIA, BranchType.YIN);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1985, 9, 22)), StemType.JIA, BranchType.ZI);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1989, 1, 1)), StemType.XIN, BranchType.YOU);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1992, 1, 28)), StemType.GUI, BranchType.MAO);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(1999, 12, 31)), StemType.DING, BranchType.SI);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(2000, 11, 11)), StemType.GUI, BranchType.YOU);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(2010, 3, 3)), StemType.REN, BranchType.ZI);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(2016, 8, 20)), StemType.JIA, BranchType.XU);
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(2016, 8, 20), LocalTime.of(23, 30)), StemType.YI, BranchType.HAI);
    }

    @Test
    public void testLeapMonthStemBranch() {
        assertPillar(fourPillarsLogic.getDay(LocalDate.of(2017, 7, 23)), StemType.XIN, BranchType.HAI);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2017, 7, 23)), StemType.DING, BranchType.WEI);

        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2017, 8, 5)), StemType.DING, BranchType.WEI);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2017, 8, 6)), StemType.DING, BranchType.WEI);

        assertPillar(fourPillarsLogic.getDay(LocalDate.of(2017, 8, 21)), StemType.GENG, BranchType.CHEN);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2017, 8, 7)), StemType.WU, BranchType.SHEN);
        assertPillar(fourPillarsLogic.getMonth(LocalDate.of(2017, 8, 21)), StemType.WU, BranchType.SHEN);
    }


    private void assertPillar(Pillar pillar, StemType stemType, BranchType branchType) {
        assertThat(pillar.getStemType()).isEqualTo(stemType);
        assertThat(pillar.getBranchType()).isEqualTo(branchType);
    }
}
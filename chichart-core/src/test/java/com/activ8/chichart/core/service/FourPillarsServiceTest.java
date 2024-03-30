package com.activ8.chichart.core.service;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import org.junit.*;

import java.time.*;

import static org.assertj.core.api.Assertions.*;

public class FourPillarsServiceTest extends AbstractUnitTest {

    private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

    private PillarProvider pillarProvider = new PillarProvider(getDataService());

    @Test
    public void fourPillarsTest_matt() {

        fourPillarsTest("Matt",
                LocalDate.of(1971, 11, 23),
                pillarProvider.createPillar(PillarType.YEAR, StemType.XIN, BranchType.HAI),
                pillarProvider.createPillar(PillarType.MONTH, StemType.JI, BranchType.HAI),
                pillarProvider.createPillar(PillarType.DAY, StemType.REN, BranchType.ZI));
    }

    @Test
    public void fourPillarsTest_kelli() {

        fourPillarsTest("Kelli",
                LocalDate.of(1973, 9, 2),
                pillarProvider.createPillar(PillarType.YEAR, StemType.GUI, BranchType.CHOU),
                pillarProvider.createPillar(PillarType.MONTH, StemType.XIN, BranchType.YOU),
                pillarProvider.createPillar(PillarType.DAY, StemType.XIN, BranchType.CHOU));
    }

    @Test
    public void fourPillarsTest_anneliese() {

        fourPillarsTest("Anneliese",
                LocalDate.of(2003, 7, 8),
                pillarProvider.createPillar(PillarType.YEAR, StemType.GUI, BranchType.WEI),
                pillarProvider.createPillar(PillarType.MONTH, StemType.JI, BranchType.WEI),
                pillarProvider.createPillar(PillarType.DAY, StemType.REN, BranchType.WU));
    }

    @Test
    public void fourPillarsTest_grant() {

        fourPillarsTest("Grant",
                LocalDate.of(1968, 3, 29),
                pillarProvider.createPillar(PillarType.YEAR, StemType.WU, BranchType.SHEN),
                pillarProvider.createPillar(PillarType.MONTH, StemType.BING, BranchType.CHEN),
                pillarProvider.createPillar(PillarType.DAY, StemType.WU, BranchType.XU));
    }

    private void fourPillarsTest(String name,
                                 LocalDate date,
                                 Pillar expectedYear,
                                 Pillar expectedMonth,
                                 Pillar expectedDay) {
        System.out.println(String.format("%s DOB: %s", name, date));

        FourPillarsChart chart = fourPillarsService.getPillars(date);

        Pillar year = chart.getYearPillar();
        System.out.println("Year: " + year);

        Pillar month = chart.getMonthPillar();
        System.out.println("Month: " + month);

        Pillar day = chart.getDayPillar();
        System.out.println("Day: " + day);

        assertThat(year.getStemType()).isEqualTo(expectedYear.getStemType());
        assertThat(year.getBranchType()).isEqualTo(expectedYear.getBranchType());

        assertThat(month.getStemType()).isEqualTo(expectedMonth.getStemType());
        assertThat(month.getBranchType()).isEqualTo(expectedMonth.getBranchType());

        assertThat(day.getStemType()).isEqualTo(expectedDay.getStemType());
        assertThat(day.getBranchType()).isEqualTo(expectedDay.getBranchType());

    }

}
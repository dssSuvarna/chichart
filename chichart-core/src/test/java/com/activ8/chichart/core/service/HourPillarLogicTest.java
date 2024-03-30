package com.activ8.chichart.core.service;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.impl.*;
import org.junit.*;

import java.time.*;

import static org.assertj.core.api.Assertions.*;

public class HourPillarLogicTest extends AbstractUnitTest {

    private HourPillarLogic hourPillarLogic = new HourPillarLogic(getDataService());

    @Test
    public void hourPillarLogic_test() {
        hourPillarTest(LocalTime.of(0,30), StemType.JIA, StemType.JIA, BranchType.ZI);
        hourPillarTest(LocalTime.of(0,59), StemType.BING, StemType.WU, BranchType.ZI);
        hourPillarTest(LocalTime.of(23,0), StemType.WU, StemType.REN, BranchType.ZI);
        hourPillarTest(LocalTime.of(0,0), StemType.GENG, StemType.BING, BranchType.ZI);
        hourPillarTest(LocalTime.of(0,20), StemType.REN, StemType.GENG, BranchType.ZI);

        hourPillarTest(LocalTime.of(5,30), StemType.JIA, StemType.DING, BranchType.MAO);
        hourPillarTest(LocalTime.of(5,30), StemType.DING, StemType.GUI, BranchType.MAO);
        hourPillarTest(LocalTime.of(5,30), StemType.GENG, StemType.JI, BranchType.MAO);
        hourPillarTest(LocalTime.of(5,30), StemType.GUI, StemType.YI, BranchType.MAO);

        hourPillarTest(LocalTime.of(19,0), StemType.YI, StemType.BING, BranchType.XU);
        hourPillarTest(LocalTime.of(19,20), StemType.WU, StemType.REN, BranchType.XU);
        hourPillarTest(LocalTime.of(20,0), StemType.XIN, StemType.WU, BranchType.XU);
        hourPillarTest(LocalTime.of(20,59), StemType.REN, StemType.GENG, BranchType.XU);

    }

    private void hourPillarTest(LocalTime time, StemType dayStemType, StemType expectedStemType, BranchType expectedBranchType) {

        Pillar pillar = hourPillarLogic.getPillar(time, dayStemType);

        assertThat(pillar.getType()).isEqualTo(PillarType.HOUR);
        assertThat(pillar.getBranchType()).isEqualTo(expectedBranchType);
        assertThat(pillar.getStemType()).isEqualTo(expectedStemType);
    }
}
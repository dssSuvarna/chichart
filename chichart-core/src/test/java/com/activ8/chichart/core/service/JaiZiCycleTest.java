package com.activ8.chichart.core.service;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.impl.*;
import org.junit.*;
import org.slf4j.*;

import static org.assertj.core.api.Assertions.*;

public class JaiZiCycleTest extends AbstractUnitTest {

    private JaiZiCycle jaiZiCycle = new JaiZiCycle(getDataService());

    private Logger logger = LoggerFactory.getLogger(JaiZiCycleTest.class);

    @Test
    public void testGetSequence() {
        assertThat(jaiZiCycle.getSequence(1).getStemType()).isEqualTo(StemType.JIA);
        assertThat(jaiZiCycle.getSequence(1).getBranchType()).isEqualTo(BranchType.ZI);
    }

    @Test
    public void outputSequences() {
        for (int i=1; i<=60; i++) {
            logger.debug(i + ": " + jaiZiCycle.getSequence(i));
        }
    }

}
package com.activ8.chichart.core.service.rulers;

import com.activ8.chichart.core.domain.*;
import org.junit.*;

import static org.assertj.core.api.Assertions.*;

public class TwelveRulersLogicTest {

    private TwelveRulersLogic provider = new TwelveRulersLogic();

    @Test
    public void chou_chou_establish() {
        assertThat(provider.getRuler(BranchType.CHOU, BranchType.CHOU)).isEqualTo(Ruler.FOUNDATION);
    }

    @Test
    public void wu_mao_collect() {
        assertThat(provider.getRuler(BranchType.WU, BranchType.MAO)).isEqualTo(Ruler.RECEIVE);
    }

    @Test
    public void you_shen_close() {
        assertThat(provider.getRuler(BranchType.YOU, BranchType.SHEN)).isEqualTo(Ruler.INSIGHTFUL);
    }

    @Test
    public void chou_you_complete() {
        assertThat(provider.getRuler(BranchType.CHOU, BranchType.YOU)).isEqualTo(Ruler.SUCCESS);
    }

    @Test
    public void you_chou_settle() {
        assertThat(provider.getRuler(BranchType.YOU, BranchType.CHOU)).isEqualTo(Ruler.STABILITY);
    }

}

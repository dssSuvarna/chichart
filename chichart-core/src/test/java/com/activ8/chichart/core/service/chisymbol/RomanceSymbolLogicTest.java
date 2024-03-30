package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;
import org.junit.*;

import static org.assertj.core.api.Assertions.*;

public class RomanceSymbolLogicTest {

    private RomanceSymbolLogic romanceSymbolLogic = new RomanceSymbolLogic();

    @Test
    public void ziMatchesChen() {
        assertThat(romanceSymbolLogic.matches(BranchType.ZI, BranchType.CHEN)).isTrue();
    }

    @Test
    public void ziDoesNotMatchHai() {
        assertThat(romanceSymbolLogic.matches(BranchType.ZI, BranchType.HAI)).isFalse();
    }

    @Test
    public void weiMatchesMao() {
        assertThat(romanceSymbolLogic.matches(BranchType.WEI, BranchType.MAO)).isTrue();
    }

    @Test
    public void weiDoesNotMatchShen() {
        assertThat(romanceSymbolLogic.matches(BranchType.WEI, BranchType.SHEN)).isFalse();
    }

}
package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import org.junit.*;

import static org.assertj.core.api.Assertions.*;

public class SnippetServiceTest extends AbstractUnitTest {

    private SnippetService snippetService = ServiceFactory.getInstance().getSnippetService();

    @Test
    public void dominant() {
        assertSnippet(LunarMethodType.DOMINANT, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A1, SnippetCode.A10);
        assertSnippet(LunarMethodType.DOMINANT, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A8, SnippetCode.A7);
        assertSnippet(LunarMethodType.DOMINANT, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A1, SnippetCode.A4);
    }

    @Test
    public void dominantEarth() {
        assertSnippet(LunarMethodType.DOMINANT_EARTH, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A1, SnippetCode.A10);
        assertSnippet(LunarMethodType.DOMINANT_EARTH, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A8, SnippetCode.A7);
        assertSnippet(LunarMethodType.DOMINANT_EARTH, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A1, SnippetCode.A4);
    }

    @Test
    public void competitive() {
        assertSnippet(LunarMethodType.COMPETITIVE, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A11, SnippetCode.A15);
        assertSnippet(LunarMethodType.COMPETITIVE, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A13, SnippetCode.A12);
        assertSnippet(LunarMethodType.COMPETITIVE, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A11, SnippetCode.A4);
    }

    @Test
    public void followThePower() {
        assertSnippet(LunarMethodType.FOLLOW_POWER, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A16, SnippetCode.A10);
        assertSnippet(LunarMethodType.FOLLOW_POWER, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A13, SnippetCode.A12);
        assertSnippet(LunarMethodType.FOLLOW_POWER, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A16, SnippetCode.A19);
    }

    @Test
    public void followTheWealth() {
        assertSnippet(LunarMethodType.FOLLOW_WEALTH, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A16, SnippetCode.A15);
        assertSnippet(LunarMethodType.FOLLOW_WEALTH, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A13, SnippetCode.A12);
        assertSnippet(LunarMethodType.FOLLOW_WEALTH, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A16, SnippetCode.A4);
    }

    @Test
    public void followTheOutput() {
        assertSnippet(LunarMethodType.FOLLOW_OUTPUT, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A16, SnippetCode.A15);
        assertSnippet(LunarMethodType.FOLLOW_OUTPUT, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A13, SnippetCode.A12);
        assertSnippet(LunarMethodType.FOLLOW_OUTPUT, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A16, SnippetCode.A4);
    }

    @Test
    public void followTheResource() {
        assertSnippet(LunarMethodType.FOLLOW_RESOURCE, StemType.JIA, BranchType.ZI, StemType.JIA, SnippetCode.A16, SnippetCode.A10);
        assertSnippet(LunarMethodType.FOLLOW_RESOURCE, StemType.XIN, BranchType.SI, StemType.JIA, SnippetCode.A13, SnippetCode.A12);
        assertSnippet(LunarMethodType.FOLLOW_RESOURCE, StemType.GUI, BranchType.HAI, StemType.GUI, SnippetCode.A16, SnippetCode.A11);
    }

    private void assertSnippet(LunarMethodType lunarMethodType, StemType dayStemType, BranchType dayBranchType, StemType dayMasterStemType,
                               SnippetCode expectedStemCode, SnippetCode expectedBranchCode) {

        Snippet snippet = snippetService.getSnippet(lunarMethodType, dayMasterStemType, dayStemType, dayBranchType);

        assertThat(snippet.getStemCode()).isEqualTo(expectedStemCode);
        assertThat(snippet.getBranchCode()).isEqualTo(expectedBranchCode);

    }
}
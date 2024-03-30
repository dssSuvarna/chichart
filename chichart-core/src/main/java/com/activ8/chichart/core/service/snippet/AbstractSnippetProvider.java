package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public abstract class AbstractSnippetProvider implements SnippetProvider {

    private SnippetLogic snippetLogic;
    private List<SnippetCode> stemMatrix;
    private List<SnippetCode> branchMatrix;

    public AbstractSnippetProvider(SnippetLogic snippetLogic, List<SnippetCode> stemMatrix, List<SnippetCode> branchMatrix) {
        this.snippetLogic = snippetLogic;
        this.stemMatrix = stemMatrix;
        this.branchMatrix = branchMatrix;
    }

    @Override
    public boolean matches(LunarMethodType lunarMethodType) {
        return getLunarMethodType() == lunarMethodType;
    }

    @Override
    public Snippet getSnippet(StemType dayMasterStemType, StemType dayStemType, BranchType dayBranchType) {
        SnippetCode stemCode = snippetLogic.getStemSnippetCode(stemMatrix, dayMasterStemType, dayStemType);
        SnippetCode branchCode = snippetLogic.getBranchSnippetCode(branchMatrix, dayMasterStemType, dayBranchType);
        return new Snippet(branchCode, stemCode);
    }

}

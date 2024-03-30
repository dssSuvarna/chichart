package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class SnippetLogic {

    public SnippetCode getStemSnippetCode(List<SnippetCode> matrix, StemType dayMasterStemType, StemType dayStemType) {
        int index = dayStemType.ordinal() * 10 + dayMasterStemType.ordinal();
        return matrix.get(index);
    }

    public SnippetCode getBranchSnippetCode(List<SnippetCode> matrix, StemType dayMasterStemType, BranchType dayBranchType) {
        int index = dayBranchType.ordinal() * 10 + dayMasterStemType.ordinal();
        return matrix.get(index);
    }
}

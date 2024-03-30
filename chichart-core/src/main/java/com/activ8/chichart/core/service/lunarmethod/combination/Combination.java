package com.activ8.chichart.core.service.lunarmethod.combination;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class Combination {

    private ElementType elementType;
    private List<BranchType> branches;

    public Combination(ElementType elementType, List<BranchType> branches) {
        this.elementType = elementType;
        this.branches = branches;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public List<BranchType> getBranches() {
        return branches;
    }
}

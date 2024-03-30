package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;

public class HiddenStem {

    private BranchType branchType;
    private StemType leftoverStemType;
    private StemType newStemType;
    private StemType pureStemType;

    public HiddenStem(BranchType branchType, StemType leftoverStemType, StemType newStemType, StemType pureStemType) {
        this.branchType = branchType;
        this.leftoverStemType = leftoverStemType;
        this.newStemType = newStemType;
        this.pureStemType = pureStemType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public void setLeftoverStemType(StemType leftoverStemType) {
        this.leftoverStemType = leftoverStemType;
    }

    public void setNewStemType(StemType newStemType) {
        this.newStemType = newStemType;
    }

    public void setPureStemType(StemType pureStemType) {
        this.pureStemType = pureStemType;
    }

    @Override
    public String toString() {
        return "HiddenStem{" +
                "branchType=" + branchType +
                ", leftoverStemType=" + leftoverStemType +
                ", newStemType=" + newStemType +
                ", pureStemType=" + pureStemType +
                '}';
    }
}

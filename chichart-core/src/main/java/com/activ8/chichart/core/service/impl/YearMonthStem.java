package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class YearMonthStem {

    private EnumSet<StemType> yearStemTypes = EnumSet.noneOf(StemType.class);
    private Integer offSet;

    public EnumSet<StemType> getYearStemTypes() {
        return yearStemTypes;
    }

    public void setYearStems(StemType stemType1, StemType stemType2) {
        this.yearStemTypes = EnumSet.of(stemType1, stemType2);
    }

    public Integer getOffSet() {
        return offSet;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }
}

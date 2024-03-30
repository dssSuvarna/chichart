package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class YearMonthStemMapping {

    private Map<StemType, Integer> yearMonthStemMapping = new HashMap<>();

    public YearMonthStemMapping() {
        yearMonthStemMapping.put(StemType.JIA, 3);
        yearMonthStemMapping.put(StemType.JI, 3);
        yearMonthStemMapping.put(StemType.YI, 5);
        yearMonthStemMapping.put(StemType.GENG, 5);
        yearMonthStemMapping.put(StemType.BING, 7);
        yearMonthStemMapping.put(StemType.XIN, 7);
        yearMonthStemMapping.put(StemType.DING, 9);
        yearMonthStemMapping.put(StemType.REN, 9);
        yearMonthStemMapping.put(StemType.WU, 1);
        yearMonthStemMapping.put(StemType.GUI, 1);
    }

    public Integer getStemMonth(StemType stemType) {
        return yearMonthStemMapping.get(stemType);
    }
}

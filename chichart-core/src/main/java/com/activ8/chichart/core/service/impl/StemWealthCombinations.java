package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class StemWealthCombinations {

    private Map<StemType, StemType> combos = new HashMap<>();

    public StemWealthCombinations() {
        combos.put(StemType.JIA, StemType.JI);
        combos.put(StemType.BING, StemType.XIN);
        combos.put(StemType.WU, StemType.GUI);
        combos.put(StemType.GENG, StemType.YI);
        combos.put(StemType.REN, StemType.DING);
    }

    public StemType getWealthCombo(StemType stemType) {
        return combos.get(stemType);
    }
}

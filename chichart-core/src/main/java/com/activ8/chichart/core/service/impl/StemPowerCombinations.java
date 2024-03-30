package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class StemPowerCombinations {

    private Map<StemType, StemType> combos = new HashMap<>();

    public StemPowerCombinations() {
        combos.put(StemType.JI, StemType.JIA);
        combos.put(StemType.XIN, StemType.BING);
        combos.put(StemType.GUI, StemType.WU);
        combos.put(StemType.YI, StemType.GENG);
        combos.put(StemType.DING, StemType.REN);
    }

    public StemType getWealthCombo(StemType stemType) {
        return combos.get(stemType);
    }
}

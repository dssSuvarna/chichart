package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class StemClashes {

    private Map<StemType, StemType> combos = new HashMap<>();

    public StemClashes() {
        combos.put(StemType.JIA, StemType.WU);
        combos.put(StemType.YI, StemType.JI);
        combos.put(StemType.BING, StemType.GENG);
        combos.put(StemType.DING, StemType.XIN);
        combos.put(StemType.WU, StemType.REN);
        combos.put(StemType.JI, StemType.GUI);
        combos.put(StemType.GENG, StemType.JIA);
        combos.put(StemType.XIN, StemType.YI);
        combos.put(StemType.REN, StemType.BING);
        combos.put(StemType.GUI, StemType.DING);
    }

    public StemType getClash(StemType stemType) {
        return combos.get(stemType);
    }
}

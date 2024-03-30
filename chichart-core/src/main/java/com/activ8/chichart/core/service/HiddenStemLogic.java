package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class HiddenStemLogic {

    private List<HiddenStem> hiddenStems = new ArrayList<>();

    public HiddenStemLogic() {
        hiddenStems.add(new HiddenStem(BranchType.ZI, null, null, StemType.GUI));
        hiddenStems.add(new HiddenStem(BranchType.CHOU, StemType.GUI, StemType.XIN, StemType.JI));
        hiddenStems.add(new HiddenStem(BranchType.YIN, StemType.WU, StemType.BING, StemType.JIA));
        hiddenStems.add(new HiddenStem(BranchType.MAO, null, null, StemType.YI));
        hiddenStems.add(new HiddenStem(BranchType.CHEN, StemType.YI, StemType.GUI, StemType.WU));
        hiddenStems.add(new HiddenStem(BranchType.SI, StemType.WU, StemType.GENG, StemType.BING));
        hiddenStems.add(new HiddenStem(BranchType.WU, null, StemType.JI, StemType.DING));
        hiddenStems.add(new HiddenStem(BranchType.WEI, StemType.DING, StemType.YI, StemType.JI));
        hiddenStems.add(new HiddenStem(BranchType.SHEN, StemType.JI, StemType.REN, StemType.GENG));
        hiddenStems.add(new HiddenStem(BranchType.YOU, null, null, StemType.XIN));
        hiddenStems.add(new HiddenStem(BranchType.XU, StemType.XIN, StemType.DING, StemType.WU));
        hiddenStems.add(new HiddenStem(BranchType.HAI, StemType.WU, StemType.JIA, StemType.REN));
    }
}

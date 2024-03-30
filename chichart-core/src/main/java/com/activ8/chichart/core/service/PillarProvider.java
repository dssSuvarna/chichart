package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;

public class PillarProvider {

    private DataService dataService;

    public PillarProvider(DataService dataService) {
        this.dataService = dataService;
    }

    private Stem getStemByType(StemType stemType) {
        return dataService.getStem(stemType);
    }

    private Branch getBranchByType(BranchType branchType) {
        return dataService.getBranch(branchType);
    }

    public Pillar createPillar(PillarType pillarType, StemType stemType, BranchType branchType) {
        return createPillar(pillarType, stemType, branchType, false);
    }

    public Pillar createPillar(PillarType pillarType, StemType stemType, BranchType branchType, boolean useStem) {
        return new Pillar(pillarType, getStemByType(stemType), getBranchByType(branchType), useStem);
    }

}

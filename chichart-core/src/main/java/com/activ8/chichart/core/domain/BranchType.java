package com.activ8.chichart.core.domain;

public enum BranchType {
    ZI(1),
    CHOU(2),
    YIN(3),
    MAO(4),
    CHEN(5),
    SI(6),
    WU(7),
    WEI(8),
    SHEN(9),
    YOU(10),
    XU(11),
    HAI(12);

    private int order;

    BranchType(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}

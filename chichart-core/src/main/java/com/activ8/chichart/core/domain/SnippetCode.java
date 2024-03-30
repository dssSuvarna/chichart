package com.activ8.chichart.core.domain;

public enum SnippetCode {

    A1(true),
    A2(true),
    A3(true),
    A4(true),
    A5(false),
    A6(false),
    A7(false),
    A8(false),
    A9(true),
    A10(true),
    A11(false),
    A12(true),
    A13(true),
    A14(false),
    A15(false),
    A16(false),
    A17(false),
    A18(false),
    A19(false),
    A20(true),
    A21(true);

    private boolean favourable;

    SnippetCode(boolean favourable) {
        this.favourable = favourable;
    }

    public boolean isFavourable() {
        return favourable;
    }
}

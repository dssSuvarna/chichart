package com.activ8.chichart.core.domain;

import java.util.*;

public class Pillar {

    private PillarType type;

    private Stem stem;

    private Branch branch;

    private boolean useStem;

    public Pillar(PillarType type, Stem stem, Branch branch, boolean useStem) {
        this.type = type;
        this.stem = stem;
        this.branch = branch;
        this.useStem = useStem;
    }

    public Pillar(PillarType type, Stem stem, Branch branch) {
        this(type, stem, branch, true);
    }

    public Pillar() {
    }

    public Stem getStem() {
        return stem;
    }

    public Branch getBranch() {
        return branch;
    }

    public PillarType getType() {
        return type;
    }

    public StemType getStemType() {
        return stem.getType();
    }

    public BranchType getBranchType() {
        return branch.getType();
    }

    public boolean isUseStem() {
        return useStem;
    }

    @Override
    public String toString() {
        return "Pillar{" +
                "type=" + type +
                ", stem=" + stem.getType() +
                ", branch=" + branch.getType() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pillar pillar = (Pillar) o;
        return type == pillar.type &&
                Objects.equals(stem, pillar.stem) &&
                Objects.equals(branch, pillar.branch);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, stem, branch);
    }
}

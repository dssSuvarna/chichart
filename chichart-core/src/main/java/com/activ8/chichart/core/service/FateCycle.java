package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class FateCycle {

    private Integer age;

    private Stem stem;

    private Branch branch;

    public FateCycle(Integer age, Stem stem, Branch branch) {
        this.age = age;
        this.stem = stem;
        this.branch = branch;
    }

    public Integer getAge() {
        return age;
    }

    public StemType getStemType() {
        return stem.getType();
    }

    public BranchType getBranchType() {
        return branch.getType();
    }

    public Stem getStem() {
        return stem;
    }

    public Branch getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "FateCycle{" +
                "age=" + age +
                ", stem=" + stem +
                ", branch=" + branch +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FateCycle fateCycle = (FateCycle) o;
        return Objects.equals(age, fateCycle.age) &&
                Objects.equals(stem, fateCycle.stem) &&
                Objects.equals(branch, fateCycle.branch);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, stem, branch);
    }
}

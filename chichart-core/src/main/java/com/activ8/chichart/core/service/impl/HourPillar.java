package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.time.*;
import java.util.*;

public class HourPillar {

    private LocalTime start;
    private LocalTime end;
    private Branch branch;
    private Integer offsetFromJia;
    private boolean useStem;
    private boolean treatAsNextDay;

    // a couple of stems have a seemingly randon hour stems, so we provide all of them rather than calculating them
    private List<StemType> stemTypes = new ArrayList<>();

    public HourPillar(LocalTime start, LocalTime end, Branch branch, Integer offsetFromJia, boolean useStem, boolean treatAsNextDay) {
        this.start = start;
        this.end = end;
        this.branch = branch;
        this.offsetFromJia = offsetFromJia;
        this.useStem = useStem;
        this.treatAsNextDay = treatAsNextDay;
    }

    public HourPillar(LocalTime start, LocalTime end, Branch branch, Integer offsetFromJia, boolean useStem) {
        this(start, end, branch, offsetFromJia, useStem, false);
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public Branch getBranch() {
        return branch;
    }

    public Integer getOffsetFromJia() {
        return offsetFromJia;
    }

    public List<StemType> getStemTypes() {
        return stemTypes;
    }

    public boolean isTreatAsNextDay() {
        return treatAsNextDay;
    }

    public boolean isUseStem() {
        return useStem;
    }

    @Override
    public String toString() {
        return "HourPillar{" +
                "start=" + start +
                ", end=" + end +
                ", branch=" + branch +
                ", offsetFromJia=" + offsetFromJia +
                '}';
    }
}

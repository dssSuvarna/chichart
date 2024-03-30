package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.time.*;
import java.util.*;

public class FourPillarsServiceImpl implements FourPillarsService {

    private FourPillarsLogic fourPillarsLogic;
    private DataService dataService;

    public FourPillarsServiceImpl(FourPillarsLogic fourPillarsLogic, DataService dataService) {
        this.fourPillarsLogic = fourPillarsLogic;
        this.dataService = dataService;
    }

    @Override
    public FourPillarsChart getPillars(LocalDate date) {
        return getPillars(date, null);
    }

    @Override
    public FourPillarsChart getPillars(LocalDate date, LocalTime time) {

        Map<PillarType, Pillar> pillars = new HashMap<>();

        Pillar year = fourPillarsLogic.getYear(date);
        pillars.put(PillarType.YEAR, new Pillar(PillarType.YEAR, getStem(year), getBranch(year)));

        Pillar month = fourPillarsLogic.getMonth(date);
        pillars.put(PillarType.MONTH, new Pillar(PillarType.MONTH, getStem(month), getBranch(month)));

        Pillar day = fourPillarsLogic.getDay(date, time);
        pillars.put(PillarType.DAY, new Pillar(PillarType.DAY, getStem(day), getBranch(day)));

        if (time != null) {
            Pillar hour = fourPillarsLogic.getHour(time, day.getStemType());
            pillars.put(PillarType.HOUR, new Pillar(PillarType.HOUR, getStem(hour), getBranch(hour)));
        }

        return new FourPillarsChart(pillars);
    }

    private Stem getStem(Pillar pillar) {
        return dataService.getStem(pillar.getStemType());
    }

    private Branch getBranch(Pillar pillar) {
        return dataService.getBranch(pillar.getBranchType());
    }

}

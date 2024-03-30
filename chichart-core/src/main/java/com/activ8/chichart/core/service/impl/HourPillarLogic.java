package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.time.*;
import java.util.*;

public class HourPillarLogic {

    private DataService dataService;

    private List<HourPillar> data = new ArrayList<>();

    public HourPillarLogic(DataService dataService) {
        this.dataService = dataService;

        data.add(new HourPillar(LocalTime.of(0, 0), LocalTime.of(0, 59), getBranch(BranchType.ZI), 0, false));
        data.add(new HourPillar(LocalTime.of(1, 0), LocalTime.of(1, 59), getBranch(BranchType.CHOU), 1, true));
        data.add(new HourPillar(LocalTime.of(2, 0), LocalTime.of(2, 59), getBranch(BranchType.CHOU), 1, false));

        data.add(new HourPillar(LocalTime.of(3, 0), LocalTime.of(3, 59), getBranch(BranchType.YIN), 2, true));
        data.add(new HourPillar(LocalTime.of(4, 0), LocalTime.of(4, 59), getBranch(BranchType.YIN), 2, false));

        data.add(new HourPillar(LocalTime.of(5, 0), LocalTime.of(5, 59), getBranch(BranchType.MAO), 3, true));
        data.add(new HourPillar(LocalTime.of(6, 0), LocalTime.of(6, 59), getBranch(BranchType.MAO), 3, false));

        data.add(new HourPillar(LocalTime.of(7, 0), LocalTime.of(7, 59), getBranch(BranchType.CHEN), 4, true));
        data.add(new HourPillar(LocalTime.of(8, 0), LocalTime.of(8, 59), getBranch(BranchType.CHEN), 4, false));

        data.add(new HourPillar(LocalTime.of(9, 0), LocalTime.of(9, 59), getBranch(BranchType.SI), 5, true));
        data.add(new HourPillar(LocalTime.of(10, 0), LocalTime.of(10, 59), getBranch(BranchType.SI), 5, false));

        data.add(new HourPillar(LocalTime.of(11, 0), LocalTime.of(11, 59), getBranch(BranchType.WU), 6, true));
        data.add(new HourPillar(LocalTime.of(12, 0), LocalTime.of(12, 59), getBranch(BranchType.WU), 6, false));

        data.add(new HourPillar(LocalTime.of(13, 0), LocalTime.of(13, 59), getBranch(BranchType.WEI), 7, true));
        data.add(new HourPillar(LocalTime.of(14, 0), LocalTime.of(14, 59), getBranch(BranchType.WEI), 7, false));

        data.add(new HourPillar(LocalTime.of(15, 0), LocalTime.of(15, 59), getBranch(BranchType.SHEN), 8, true));
        data.add(new HourPillar(LocalTime.of(16, 0), LocalTime.of(16, 59), getBranch(BranchType.SHEN), 8, false));

        data.add(new HourPillar(LocalTime.of(17, 0), LocalTime.of(17, 59), getBranch(BranchType.YOU), 9, true));
        data.add(new HourPillar(LocalTime.of(18, 0), LocalTime.of(18, 59), getBranch(BranchType.YOU), 9, false));

        data.add(new HourPillar(LocalTime.of(19, 0), LocalTime.of(19, 59), getBranch(BranchType.XU), 0, true));
        data.add(new HourPillar(LocalTime.of(20, 0), LocalTime.of(20, 59), getBranch(BranchType.XU), 0, false));

        data.add(new HourPillar(LocalTime.of(21, 0), LocalTime.of(21, 59), getBranch(BranchType.HAI), 1, true));
        data.add(new HourPillar(LocalTime.of(22, 0), LocalTime.of(22, 59), getBranch(BranchType.HAI), 1, false));

        data.add(new HourPillar(LocalTime.of(23, 0), LocalTime.of(23, 59), getBranch(BranchType.ZI), 0, true, true));

    }

    // if a person is born between 23:00 and before midnight, they are considered to be born the next day
    public boolean isDayPillarNextDay(LocalTime time) {
        return getHourPillar(time).isTreatAsNextDay();
    }

    public Pillar getPillar(LocalTime time, StemType dayStemType) {

        HourPillar hourData = getHourPillar(time);

        StemType stemType;

        if (hourData.getStemTypes().isEmpty()) {
            int hourStemNumber = (hourData.getOffsetFromJia() + (dayStemType.ordinal() * 2)) % 10;
            stemType = StemType.values()[hourStemNumber];
        } else {
            stemType = hourData.getStemTypes().get(dayStemType.ordinal());
        }

        return new Pillar(PillarType.HOUR, getStem(stemType), hourData.getBranch(), hourData.isUseStem());
    }

    private HourPillar getHourPillar(LocalTime time) {

        for(HourPillar d : data) {
            if ((d.getStart().equals(time) || d.getStart().isBefore(time) && d.getEnd().equals(time) || d.getEnd().isAfter(time))) {
                return d;
            }
        }

        throw new RuntimeException(String.format("Could not calculate pillar for time %s", time));
    }

    private Branch getBranch(BranchType type) {
        return dataService.getBranch(type);
    }

    private Stem getStem(StemType type) {
        return dataService.getStem(type);
    }

}

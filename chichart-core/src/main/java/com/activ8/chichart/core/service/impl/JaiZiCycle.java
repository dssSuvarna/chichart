package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.util.*;

public class JaiZiCycle {

    private List<Pillar> data = new ArrayList<>();

    public JaiZiCycle(DataService dataService) {
        List<Stem> stems = dataService.getStems();
        List<Branch> branches = dataService.getBranches();

        for (int i = 0; i < 60; i++) {
            int stem = i % 10;
            int branch = i % 12;

            data.add(new Pillar(PillarType.YEAR, stems.get(stem), branches.get(branch)));
        }
    }

    public Pillar getSequence(Integer year) {
        if (year < 1) year = 60 - Math.abs(year);
        if (year > 60) year = year - 60;

        return data.get(year - 1);
    }

    public Integer getYearNumber(Pillar key) {
        key = new Pillar(PillarType.YEAR, key.getStem(), key.getBranch());

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(key)) return i + 1; // storage is zero based
        }
        throw new RuntimeException("Could not find entry for key " + key);
    }
}

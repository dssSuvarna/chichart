package com.activ8.chichart.core.domain;

import java.util.*;

public class FourPillarsChart {

    private Map<PillarType, Pillar> pillars;

    public FourPillarsChart(Map<PillarType, Pillar> pillars) {
        this.pillars = pillars;
    }

    public FourPillarsChart(Pillar dayPillar, Pillar monthPillar, Pillar yearPillar) {
        pillars = new HashMap<>();
        pillars.put(PillarType.DAY, dayPillar);
        pillars.put(PillarType.MONTH, monthPillar);
        pillars.put(PillarType.YEAR, yearPillar);
    }

    public Map<PillarType, Pillar> getPillars() {
        return pillars;
    }

    public List<Pillar> getPillarsList() {
        return new ArrayList<>(pillars.values());
    }

    public List<BranchType> getBranchTypes() {
        List<BranchType> branchTypes = new ArrayList<>();
        for (Pillar pillar : pillars.values()) {
            if (pillar.getBranch() != null) {
                branchTypes.add(pillar.getBranchType());
            }
        }

        return branchTypes;
    }

    public List<BranchType> getBranchTypesExcludeHour() {

        List<BranchType> branchTypes = new ArrayList<>();
        for (Pillar pillar : pillars.values()) {
            if (!pillar.getType().equals(PillarType.HOUR) && pillar.getBranch() != null) {
                branchTypes.add(pillar.getBranchType());
            }
        }

        return branchTypes;
    }

    public Pillar getYearPillar() {
        return pillars.get(PillarType.YEAR);
    }

    public Pillar getMonthPillar() {
        return pillars.get(PillarType.MONTH);
    }

    public Pillar getDayPillar() {
        return pillars.get(PillarType.DAY);
    }

    public Pillar getHourPillar() {
        return pillars.get(PillarType.HOUR);
    }

    public Pillar getActiveFacteCyclePillar() {
        return pillars.get(PillarType.ACTIVE_FATE_CYCLE);
    }

    // if we dont find a lunar method match using the four pillars, we progressively add other pillar elements in an effort to find a match
    // We pillars in the following order
    // - active fate cycle pillar
    // - current year pillar
    // - current month pillar
    // - current day pillar
    public void addPillar(Pillar pillar) {
        pillars.put(pillar.getType(), pillar);
    }

    public void removePillars(PillarType... pillarTypes) {
        for (PillarType pillarType : pillarTypes) {
            pillars.remove(pillarType);
        }
    }
}

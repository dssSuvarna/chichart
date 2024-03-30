package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.time.*;
import java.util.*;

public class FateCycleServiceImpl implements FateCycleService {

    private FourPillarsLogic fourPillarsLogic;

    private JaiZiCycle jaiZiCycle;

    private FateCycleLogic fateCycleLogic;

    public FateCycleServiceImpl(FourPillarsLogic fourPillarsLogic, JaiZiCycle jaiZiCycle, FateCycleLogic fateCycleLogic) {
        this.fourPillarsLogic = fourPillarsLogic;
        this.jaiZiCycle = jaiZiCycle;
        this.fateCycleLogic = fateCycleLogic;
    }

    /*
         Calculating the Fate Cycles

         The first step in determining the Fate Cycles for a person is whether the cycles run forwards or backwards.
         This is done by looking at the Year Pillar -
         Female with Yin Pillar goes forwards Female with Yang Pillar goes backwards Male with Yang Pillar goes forwards Male with Yin Pillar goes backwards.

         If forward, count the number of days from the day of birth to the next beginning of month Qi change.
         If the day of birth coincides with the Qi change then you will need to check the time of birth and the time of Qi change.
         If backward, count back from the day of birth to the last beginning of month chi change.
         Divide this number by three and round to the nearest whole number.

         The result gives the age that the Great Fate starts. The Fate Cycles run for 10 years each.

         The fate pillars follow on from the month pillar so that for forwards - The first fate pillar consists of the next Stem and the next Branch and so on.

         For backwards the first fate pillar consists of the Stem and Branch before the month Stem and Branch, and so on.
        */
    public List<FateCycle> getFateCycles(LocalDate date, Gender gender, DualityType dualityType) {

        // age at which fate cycles start
        Integer fateCycleAge = fateCycleLogic.getFateCycleStartAge(date, gender, dualityType);
        boolean forward = fateCycleLogic.isForward(gender, dualityType);

        List<FateCycle> fateCycles = new ArrayList<>();

        // month pillar of the nearest start of month
        Pillar monthPillarReference = fourPillarsLogic.getMonth(date);
        Integer monthReferenceYearNumber = jaiZiCycle.getYearNumber(monthPillarReference);

        for (int i = 0; i < 10; i++) {
            if (forward) {
                monthReferenceYearNumber++;
            } else {
                monthReferenceYearNumber--;
            }

            Pillar monthPillar = jaiZiCycle.getSequence(monthReferenceYearNumber);
            fateCycles.add(new FateCycle(fateCycleAge + (10 * i),
                    monthPillar.getStem(),
                    monthPillar.getBranch()));
        }

        return fateCycles;
    }

    /**
     * Get the fate cycle having an age closest to the dob specified, but not greater than.
     * <p>
     * If the person's age is less than the age of the first fate cycle, return the first fate cycle.
     */
    public FateCycle getActiveFateCycle(LocalDate dob, LocalDate date, List<FateCycle> fateCycles) {

        int ageInyears = Period.between(dob, date).getYears();
        FateCycle first = fateCycles.get(0);

        List<FateCycle> sorted = new ArrayList<>(fateCycles);

        sorted.sort((o1, o2) -> o2.getAge().compareTo(o1.getAge()));

        for (FateCycle fateCycle : sorted) {
            if (fateCycle.getAge() <= ageInyears) {
                return fateCycle;
            }
        }

        return first;

    }

}

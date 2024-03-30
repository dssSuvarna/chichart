package com.activ8.chichart.core.service.rulers;

public class RulerServiceImpl implements RulerService {

    private RulersDescriptionProvider rulersDescriptionProvider = new RulersDescriptionProvider();

    @Override
    public String getRulerDescription(Ruler ruler) {
        return rulersDescriptionProvider.getDescription(ruler);
    }
}

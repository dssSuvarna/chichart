package com.activ8.chichart.core.domain;

public class Duality extends AbstractEntity implements HasName {

    private DualityType type;

    private String name;

    public Duality(Integer id, DualityType type, String name) {
        this.type = type;
        this.name = name;
        setId(id);
    }

    public String getName() {
        return name;
    }

    public DualityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Duality {" +
                "type=" + type +
                '}';
    }

}
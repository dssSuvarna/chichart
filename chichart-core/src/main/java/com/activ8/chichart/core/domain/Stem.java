package com.activ8.chichart.core.domain;

public class Stem extends AbstractEntity implements HasName, HasDuality, HasElement {

    private StemType type;
    private Duality duality;
    private Element element;
    private String name;

    public Stem(Integer id, StemType type, Duality duality, Element element, String name) {
        this.type = type;
        this.duality = duality;
        this.element = element;
        this.name = name;
        setId(id);
    }

    public StemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public Duality getDuality() {
        return duality;
    }

    public Element getElement() {
        return element;
    }

    @Override
    public String toString() {
        return "Stem{" +
                "type=" + type +
                ", element=" + element +
                ", duality=" + duality +
                '}';
    }

}


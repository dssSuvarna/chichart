package com.activ8.chichart.core.domain;

public class Branch extends AbstractEntity implements HasName, HasDuality, HasElement {

    private BranchType type;
    private Duality duality;
    private Element element;
    private String name;
    private Integer westernMonthStartDay;
    private Integer westernMonthStartMonth;
    private Animal animal;

    public Branch(Integer id, BranchType type, Duality duality, Element element, String name, Integer westernMonthStartDay, Integer westernMonthStartMonth, Animal animal) {
        this.type = type;
        this.duality = duality;
        this.element = element;
        this.name = name;
        this.westernMonthStartDay = westernMonthStartDay;
        this.westernMonthStartMonth = westernMonthStartMonth;
        this.animal = animal;
        setId(id);
    }

    public Integer getWesternMonthStartDay() {
        return westernMonthStartDay;
    }

    public Integer getWesternMonthStartMonth() {
        return westernMonthStartMonth;
    }

    public BranchType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Duality getDuality() {
        return duality;
    }

    public Element getElement() {
        return element;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return "Branch {" +
                "type=" + type +
                ", element=" + element +
                ", duality=" + duality +
                '}';
    }

}


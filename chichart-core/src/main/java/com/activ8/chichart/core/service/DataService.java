package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;

import java.util.*;


public class DataService {

    private Duality YIN = new Duality(1, DualityType.YIN, "Yin");
    private Duality YANG = new Duality(2, DualityType.YANG, "Yang");

    private List<Branch> branches = new ArrayList<>();
    private List<Stem> stems = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public DataService() {
        populate();
    }

    private void populate() {
        populateElements();
        populateStems();
        populateBranches();
    }

    private void populateBranches() {
        branches.add(new Branch(1, BranchType.ZI, YANG, getElement(ElementType.WATER), "Zi", 7, 12, Animal.RAT));
        branches.add(new Branch(2, BranchType.CHOU, YIN, getElement(ElementType.EARTH), "Chou", 6, 1, Animal.OX));
        branches.add(new Branch(3, BranchType.YIN, YANG, getElement(ElementType.WOOD), "Yin", 4, 2, Animal.TIGER));
        branches.add(new Branch(4, BranchType.MAO, YIN, getElement(ElementType.WOOD), "Mao", 5, 3, Animal.RABBIT));
        branches.add(new Branch(5, BranchType.CHEN, YANG, getElement(ElementType.EARTH), "Chen", 5, 4, Animal.DRAGON));
        branches.add(new Branch(6, BranchType.SI, YIN, getElement(ElementType.FIRE), "Si", 6, 5, Animal.SNAKE));
        branches.add(new Branch(7, BranchType.WU, YANG, getElement(ElementType.FIRE), "Wu", 6, 6, Animal.HORSE));
        branches.add(new Branch(8, BranchType.WEI, YIN, getElement(ElementType.EARTH), "Wei", 7, 7, Animal.SHEEP));
        branches.add(new Branch(9, BranchType.SHEN, YANG, getElement(ElementType.METAL), "Shen", 8, 8, Animal.MONKEY));
        branches.add(new Branch(10, BranchType.YOU, YIN, getElement(ElementType.METAL), "You", 8, 9, Animal.ROOSTER));
        branches.add(new Branch(11, BranchType.XU, YANG, getElement(ElementType.EARTH), "Xu", 8, 10, Animal.DOG));
        branches.add(new Branch(12, BranchType.HAI, YIN, getElement(ElementType.WATER), "Hai", 8, 11, Animal.PIG));
    }

    private void populateStems() {
        stems.add(new Stem(1, StemType.JIA, YANG, getElement(ElementType.WOOD), "Jia" ));
        stems.add(new Stem(2, StemType.YI, YIN, getElement(ElementType.WOOD), "Yi" ));
        stems.add(new Stem(3, StemType.BING, YANG, getElement(ElementType.FIRE), "Bing" ));
        stems.add(new Stem(4, StemType.DING, YIN, getElement(ElementType.FIRE), "Ding" ));
        stems.add(new Stem(5, StemType.WU, YANG, getElement(ElementType.EARTH), "Wu" ));
        stems.add(new Stem(6, StemType.JI, YIN, getElement(ElementType.EARTH), "Ji" ));
        stems.add(new Stem(7, StemType.GENG, YANG, getElement(ElementType.METAL), "Geng" ));
        stems.add(new Stem(8, StemType.XIN, YIN, getElement(ElementType.METAL), "Xin" ));
        stems.add(new Stem(9, StemType.REN, YANG, getElement(ElementType.WATER), "Ren" ));
        stems.add(new Stem(10, StemType.GUI, YIN, getElement(ElementType.WATER), "Gui" ));
    }

    private void populateElements() {
        elements.add(new Element(1, ElementType.WOOD, "Wood"));
        elements.add(new Element(2, ElementType.FIRE, "Fire"));
        elements.add(new Element(3, ElementType.EARTH, "Earth"));
        elements.add(new Element(4, ElementType.METAL, "Metal"));
        elements.add(new Element(5, ElementType.WATER, "Water"));

        addRelatedElement(1, ElementType.WOOD, ElementType.METAL, RelationshipType.POWER);
        addRelatedElement(2, ElementType.FIRE, ElementType.WATER, RelationshipType.POWER);
        addRelatedElement(3, ElementType.EARTH, ElementType.WOOD, RelationshipType.POWER);
        addRelatedElement(4, ElementType.METAL, ElementType.FIRE, RelationshipType.POWER);
        addRelatedElement(5, ElementType.WATER, ElementType.EARTH, RelationshipType.POWER);

        addRelatedElement(6, ElementType.WOOD, ElementType.EARTH, RelationshipType.WEALTH);
        addRelatedElement(7, ElementType.FIRE, ElementType.METAL, RelationshipType.WEALTH);
        addRelatedElement(8, ElementType.EARTH, ElementType.WATER, RelationshipType.WEALTH);
        addRelatedElement(9, ElementType.METAL, ElementType.WOOD, RelationshipType.WEALTH);
        addRelatedElement(10, ElementType.WATER, ElementType.FIRE, RelationshipType.WEALTH);

        addRelatedElement(11, ElementType.WOOD, ElementType.WATER, RelationshipType.RESOURCE);
        addRelatedElement(12, ElementType.FIRE, ElementType.WOOD, RelationshipType.RESOURCE);
        addRelatedElement(13, ElementType.EARTH, ElementType.FIRE, RelationshipType.RESOURCE);
        addRelatedElement(14, ElementType.METAL, ElementType.EARTH, RelationshipType.RESOURCE);
        addRelatedElement(15, ElementType.WATER, ElementType.METAL, RelationshipType.RESOURCE);

        addRelatedElement(16, ElementType.WOOD, ElementType.FIRE, RelationshipType.OUTPUT);
        addRelatedElement(17, ElementType.FIRE, ElementType.EARTH, RelationshipType.OUTPUT);
        addRelatedElement(18, ElementType.EARTH, ElementType.METAL, RelationshipType.OUTPUT);
        addRelatedElement(19, ElementType.METAL, ElementType.WATER, RelationshipType.OUTPUT);
        addRelatedElement(20, ElementType.WATER, ElementType.WOOD, RelationshipType.OUTPUT);

    }

    private void addRelatedElement(Integer id, ElementType type, ElementType relatedType, RelationshipType relationship) {
        Element element = getElement(type);
        element.getRelationships().add(new RelatedElement(id, type, relatedType, relationship));
    }

    public Element getElement(ElementType type) {

        for (Element e : elements) {
            if (e.getType().equals(type)) {
                return e;
            }
        }
        throw new RuntimeException(String.format("Could not find element for %s ", type));
    }

    public Stem getStem(StemType type) {

        for (Stem s : stems) {
            if (s.getType().equals(type)) {
                return s;
            }
        }
        throw new RuntimeException(String.format("Could not find stem for %s ", type));
    }

    public Branch getBranch(BranchType type) {
        for (Branch b : branches) {
            if (b.getType().equals(type)) {
                return b;
            }
        }
        throw new RuntimeException(String.format("Could not find branch for %s ", type));
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Stem> getStems() {
        return stems;
    }
}

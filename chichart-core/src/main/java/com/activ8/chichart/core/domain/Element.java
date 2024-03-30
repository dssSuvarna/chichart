package com.activ8.chichart.core.domain;

import java.util.*;

public class Element extends AbstractEntity implements HasName {

    private ElementType type;

    private String name;

    private Set<RelatedElement> relationships = new HashSet<>();

    public ElementType getType() {
        return type;
    }

    public Element(Integer id, ElementType type, String name) {
        this.type = type;
        this.name = name;
        setId(id);
    }

    @Override
    public String getName() {
        return name;
    }

    public Set<RelatedElement> getRelationships() {
        return relationships;
    }

    public ElementType getPowerElement() {
        return getRelatedElement(RelationshipType.POWER);
    }

    public ElementType getOutputElement() {
        return getRelatedElement(RelationshipType.OUTPUT);
    }

    public ElementType getResourceElement() {
        return getRelatedElement(RelationshipType.RESOURCE);
    }

    public ElementType getWealthElement() {
        return getRelatedElement(RelationshipType.WEALTH);
    }

    public ElementType getRelatedElement(RelationshipType type) {
        if (type == RelationshipType.SELF) {
            return this.getType();
        } else {
            for (RelatedElement e : getRelationships()) {
                if (e.getRelationshipType().equals(type)) {
                    return e.getRelated();
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "Element {" +
                "type=" + type +
                '}';
    }

}
package com.activ8.chichart.core.domain;

public class RelatedElement extends AbstractEntity {

    private ElementType elementType;

    private ElementType related;

    private RelationshipType relationshipType;

    public RelatedElement(Integer id, ElementType element, ElementType related, RelationshipType relationshipType) {
        this.elementType = element;
        this.related = related;
        this.relationshipType = relationshipType;
        setId(id);
    }

    public ElementType getElement() {
        return elementType;
    }

    public ElementType getRelated() {
        return related;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
}
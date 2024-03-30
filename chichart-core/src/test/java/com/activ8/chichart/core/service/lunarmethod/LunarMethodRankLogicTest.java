package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import org.junit.*;
import org.slf4j.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LunarMethodRankLogicTest extends AbstractUnitTest {

    private LunarMethodRankLogic lunarMethodRankLogic = new LunarMethodRankLogic();

    private Logger logger = LoggerFactory.getLogger(LunarMethodRankLogicTest.class);

    @Test
    public void hourPillarLogic_dominant() {
        testLunarMethodType(LunarMethodType.DOMINANT,
                RelationshipType.RESOURCE, RelationshipType.SELF, RelationshipType.OUTPUT, RelationshipType.WEALTH, RelationshipType.POWER);
    }

    @Test
    public void hourPillarLogic_competitive() {
        testLunarMethodType(LunarMethodType.COMPETITIVE,
                RelationshipType.OUTPUT, RelationshipType.POWER, RelationshipType.SELF, RelationshipType.RESOURCE, RelationshipType.WEALTH);
    }

    @Test
    public void hourPillarLogic_power() {
        testLunarMethodType(LunarMethodType.FOLLOW_POWER,
                RelationshipType.POWER, RelationshipType.WEALTH, RelationshipType.RESOURCE, RelationshipType.SELF, RelationshipType.OUTPUT);
    }

    @Test
    public void hourPillarLogic_wealth() {
        testLunarMethodType(LunarMethodType.FOLLOW_WEALTH,
                RelationshipType.WEALTH, RelationshipType.OUTPUT, RelationshipType.POWER, RelationshipType.RESOURCE, RelationshipType.SELF);
    }

    @Test
    public void hourPillarLogic_output() {
        testLunarMethodType(LunarMethodType.FOLLOW_OUTPUT,
                RelationshipType.OUTPUT, RelationshipType.WEALTH, RelationshipType.POWER, RelationshipType.SELF, RelationshipType.RESOURCE);
    }

    @Test
    public void hourPillarLogic_resource() {
        testLunarMethodType(LunarMethodType.FOLLOW_RESOURCE,
                RelationshipType.RESOURCE, RelationshipType.POWER, RelationshipType.OUTPUT, RelationshipType.WEALTH, RelationshipType.SELF);
    }

    private void testLunarMethodType(LunarMethodType lunarMethodType, RelationshipType... relationships) {
        for (ElementType elementType : ElementType.values()) {
            test(lunarMethodType, getDataService().getElement(elementType), relationships);
        }
    }

    private void test(LunarMethodType lunarMethodType, Element element, RelationshipType... relationships) {
        logger.info(String.format("Testing %s, %s", lunarMethodType, element));
        List<ElementType> elements = lunarMethodRankLogic.getRankedElements(lunarMethodType, element);

        int i=0;
        for (RelationshipType relationshipType : relationships) {
            assertThat(element.getRelatedElement(relationshipType)).isEqualTo(elements.get(i));
            i++;
        }
    }
}
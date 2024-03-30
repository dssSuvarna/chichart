package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;

public interface LunarMethod {

    boolean matches(FourPillarsChart chart, int currentAge);

    String getName(FourPillarsChart chart);

    LunarMethodType getType();

    Integer getOrder();


}

package com.activ8.chichart.core.service;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;

import java.util.*;

public interface LunarMethodService {

    LunarMethod getLunarMethod(LunarMethodCommand command);

    List<ElementType> getRankedElements(LunarMethodType lunarMethodType, Element element);

    List<RankedStem> getRankedStems(FourPillarsChart chart, LunarMethod lunarMethod, Element element);

    List<RankedBranch> getRankedBranches(FourPillarsChart chart, LunarMethod lunarMethod, Element element);
}

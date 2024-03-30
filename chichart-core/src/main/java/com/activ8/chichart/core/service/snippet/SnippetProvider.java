package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

public interface SnippetProvider {
    boolean matches(LunarMethodType lunarMethodType);
    Snippet getSnippet(StemType dayMasterStemType, StemType dayStemType, BranchType dayBranchType);
    LunarMethodType getLunarMethodType();
}

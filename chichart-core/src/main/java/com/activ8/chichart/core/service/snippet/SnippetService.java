package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.month.*;

import java.util.*;

public interface SnippetService {
    Snippet getSnippet(LunarMethodType lunarMethodType, StemType dayMasterStemType, StemType dayStemType, BranchType dayBranchType);

    void injectSnippets(LunarMethodType lunarMethodType, StemType dayMasterStemType, List<CalendarDay> calendarDays);

    String getSnippetDescription(SnippetCode snippetCode);
}

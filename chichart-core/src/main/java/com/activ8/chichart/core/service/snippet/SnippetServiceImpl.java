package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.month.*;

import java.util.*;

public class SnippetServiceImpl implements SnippetService {

    private List<SnippetProvider> snippetProviders = new ArrayList<>();
    private SnippetDescriptionProvider snippetDescriptionProvider = new SnippetDescriptionProvider();

    public SnippetServiceImpl(SnippetLogic snippetLogic) {
        snippetProviders.add(new DominantSnippetProvider(snippetLogic));
        snippetProviders.add(new CompetitiveSnippetProvider(snippetLogic));
        snippetProviders.add(new FollowTheOutputSnippetProvider(snippetLogic));
        snippetProviders.add(new FollowThePowerSnippetProvider(snippetLogic));
        snippetProviders.add(new FollowTheWealthSnippetProvider(snippetLogic));
        snippetProviders.add(new FollowTheResourceSnippetProvider(snippetLogic));
        snippetProviders.add(new UnknownSnippetProvider(snippetLogic));
    }

    @Override
    public Snippet getSnippet(LunarMethodType lunarMethodType, StemType dayMasterStemType, StemType dayStemType, BranchType dayBranchType) {
        return getSnippetProvider(lunarMethodType).getSnippet(dayMasterStemType, dayStemType, dayBranchType);
    }

    @Override
    public void injectSnippets(LunarMethodType lunarMethodType, StemType dayMasterStemType, List<CalendarDay> calendarDays) {
        for (CalendarDay calendarDay : calendarDays) {
            calendarDay.setSnippet(getSnippet(lunarMethodType, dayMasterStemType, calendarDay.getDayPillar().getStemType(), calendarDay.getDayPillar().getBranchType()));
        }
    }

    @Override
    public String getSnippetDescription(SnippetCode snippetCode) {
        return snippetDescriptionProvider.getDescription(snippetCode);
    }

    private SnippetProvider getSnippetProvider(LunarMethodType lunarMethodType) {

        SnippetProvider snippetProvider = null;

        for (SnippetProvider sp : snippetProviders) {
            if (sp.matches(lunarMethodType)) {
                snippetProvider = sp;
                break;
            }
        }

        return snippetProvider;
    }

}

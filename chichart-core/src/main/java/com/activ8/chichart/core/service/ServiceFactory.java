package com.activ8.chichart.core.service;

import com.activ8.chichart.core.service.characteristics.*;
import com.activ8.chichart.core.service.chisymbol.*;
import com.activ8.chichart.core.service.impl.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;
import com.activ8.chichart.core.service.month.*;
import com.activ8.chichart.core.service.rulers.*;
import com.activ8.chichart.core.service.snippet.*;
import com.ibm.icu.util.*;

/**
 * We can't use standard Spring dependency injection because this code is being shared with the Android app.
 *
 * Create a singleton class that returns service/logic instances
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private DataService dataService = new DataService();

    private ChineseCalendar chineseCalendar = (ChineseCalendar) Calendar.getInstance(new ULocale("en_AU@calendar=chinese"));
    private JaiZiCycle jaiZiCycle = new JaiZiCycle(dataService);
    private HourPillarLogic hourPillarLogic = new HourPillarLogic(dataService);
    private PillarProvider pillarProvider = new PillarProvider(dataService);
    private FourPillarsLogic fourPillarsLogic = new FourPillarsLogic(chineseCalendar, jaiZiCycle, hourPillarLogic, pillarProvider);
    private FateCycleLogic fateCycleLogic = new FateCycleLogic(dataService);
    private HarmonyCombinationLogic harmonyCombinationLogic = new HarmonyCombinationLogic();
    private SeasonalCombinationLogic seasonalCombinationLogic = new SeasonalCombinationLogic();
    private StandardStemElementRanker standardStemElementRanker = new StandardStemElementRanker(dataService);
    private StandardBranchElementRanker standardBranchElementRanker = new StandardBranchElementRanker(dataService);
    private CombinationElementRanker combinationElementRanker = new CombinationElementRanker(seasonalCombinationLogic, harmonyCombinationLogic);
    private ElementRankLogic elementRankLogic = new ElementRankLogic(standardStemElementRanker, standardBranchElementRanker, combinationElementRanker);
    private CombinationLogic combinationLogic = new CombinationLogic(seasonalCombinationLogic, harmonyCombinationLogic);
    private SnippetLogic snippetLogic = new SnippetLogic();
    private BranchClashLogic branchClashLogic = new BranchClashLogic();
    private FourPillarsService fourPillarsService = new FourPillarsServiceImpl(fourPillarsLogic, dataService);
    private FateCycleService fateCycleService = new FateCycleServiceImpl(fourPillarsLogic, jaiZiCycle, fateCycleLogic);
    private LunarMethodService lunarMethodService = new LunarMethodServiceImpl(elementRankLogic, fateCycleService, fourPillarsLogic, seasonalCombinationLogic, harmonyCombinationLogic,
            combinationLogic, fateCycleLogic);
    private TwelveRulersLogic twelveRulersLogic = new TwelveRulersLogic();
    private CalendarService calendarService = new CalendarServiceImpl(fourPillarsLogic, lunarMethodService, branchClashLogic, twelveRulersLogic);
    private SnippetService snippetService = new SnippetServiceImpl(snippetLogic);
    private RulerService rulerService = new RulerServiceImpl();
    private ChiSymbolService chiSymbolService = new ChiSymbolServiceImpl();
    private PillarCharacteristicsService pillarCharacteristicsService = new PillarCharacteristicsServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public DataService getDataService() {
        return dataService;
    }

    public FourPillarsService getFourPillarsService() {
        return fourPillarsService;
    }

    public FateCycleService getFateCycleService() {
        return fateCycleService;
    }

    public LunarMethodService getLunarMethodService() {
        return lunarMethodService;
    }

    public CalendarService getCalendarService() {
        return calendarService;
    }

    public FourPillarsLogic getFourPillarsLogic() {
        return fourPillarsLogic;
    }

    public ElementRankLogic getElementRankLogic() {
        return elementRankLogic;
    }

    public SnippetService getSnippetService() {
        return snippetService;
    }

    public ChiSymbolService getChiSymbolService() {
        return chiSymbolService;
    }

    public BranchClashLogic getBranchClashLogic() {
        return branchClashLogic;
    }

    public RulerService getRulerService() {
        return rulerService;
    }

    public PillarCharacteristicsService getPillarCharacteristicsService() {
        return pillarCharacteristicsService;
    }
}

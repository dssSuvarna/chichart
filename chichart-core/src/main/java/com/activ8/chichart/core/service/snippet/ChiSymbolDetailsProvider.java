package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.chisymbol.*;

import java.util.*;

public class ChiSymbolDetailsProvider {

    private static ChiSymbolDetails TRAVEL = new ChiSymbolDetails(ChiSymbol.TRAVEL, "Today is a travel day. Whether for business or pleasure, you'll create some movement.");
    private static ChiSymbolDetails ACADEMIC = new ChiSymbolDetails(ChiSymbol.ACADEMIC, "The Chi of today is ideal for education and learning.");
    private static ChiSymbolDetails CELEBRATION = new ChiSymbolDetails(ChiSymbol.CELEBRATION, "Look for the wins in your life today, there's always a reason to celebrate!");
    private static ChiSymbolDetails ROMANCE = new ChiSymbolDetails(ChiSymbol.ROMANCE, "Today is great for romance and all of your long-term relationships.");
    private static ChiSymbolDetails HEALTH = new ChiSymbolDetails(ChiSymbol.HEALTH, "Look after your health today - physical, mental and spiritual.");

    private static Map<ChiSymbolDetailsKey, String> descriptions = new HashMap<>();

    static {
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A1, ChiSymbol.CAREER_BUSINESS), "Career and business relationships are at the fore-front today. Negotiations will go in your favour.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A2, ChiSymbol.CAREER_BUSINESS), "Career and business relationships are at the fore-front today. Negotiations will go in your favour.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A3, ChiSymbol.FAMILY_CREATIVITY), "It's a great day to get creative, plan and bring ideas to fruition. If you have children, enjoy spending time with them.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A4, ChiSymbol.FAMILY_CREATIVITY), "It's a great day to get creative, plan and bring ideas to fruition. If you have children, enjoy spending time with them.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A5, ChiSymbol.MONEY), "Today is a good day to assess your finances and plan for the future.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A6, ChiSymbol.MONEY), "Today is a good day to assess your finances and plan for the future.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A7, ChiSymbol.MAGNIFYING_GLASS), "Scrutinise the details of everything that crosses your path today.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A8, ChiSymbol.MAGNIFYING_GLASS), "Scrutinise the details of everything that crosses your path today.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A9, ChiSymbol.ACADEMIC), "The Chi of today is ideal for education and learning.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A10, ChiSymbol.ACADEMIC), "The Chi of today is ideal for education and learning.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A11, ChiSymbol.MAGNIFYING_GLASS), "Scrutinise the details of everything that crosses your path today.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A12, ChiSymbol.CAREER_BUSINESS), "Career and business relationships are at the fore-front. It's a good day to lead by example.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A13, ChiSymbol.CAREER_BUSINESS), "Career and business relationships are at the fore-front. It's a good day to lead by example.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A14, ChiSymbol.HEALTH), "Look after your health today - physical, mental and spiritual.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A15, ChiSymbol.HEALTH), "Look after your health today - physical, mental and spiritual.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A16, ChiSymbol.MAGNIFYING_GLASS), "Scrutinise the details of everything that crosses your path today.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A17, ChiSymbol.MAGNIFYING_GLASS), "Scrutinise the details of everything that crosses your path today.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A18, ChiSymbol.FAMILY_CREATIVITY), "Your creative juices may be running hot, but keep a lid on some of your more outrageous ideas. Be kind to your spouse and children.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A19, ChiSymbol.FAMILY_CREATIVITY), "Your creative juices may be running hot, but keep a lid on some of your more outrageous ideas. Be kind to your spouse and children.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A20, ChiSymbol.MONEY), "Look for opportunities around you, there may be some good money luck on the way today.");
        descriptions.put(new ChiSymbolDetailsKey(SnippetCode.A21, ChiSymbol.MONEY), "Look for opportunities around you, there may be some good money luck on the way today.");
    }

    public ChiSymbolDetails getDescription(SnippetCode snippetCode) {
        for (ChiSymbolDetailsKey key : descriptions.keySet()) {
            if (key.getSnippetCode().equals(snippetCode)) {
                return new ChiSymbolDetails(key.getChiSymbol(), descriptions.get(key));
            }
        }

        throw new RuntimeException(String.format("Could not find details for snippet %s", snippetCode));
    }

    public ChiSymbolDetails getTravel() {
        return TRAVEL;
    }

    public ChiSymbolDetails getAcademic() {
        return ACADEMIC;
    }

    public ChiSymbolDetails getCelebration() {
        return CELEBRATION;
    }

    public ChiSymbolDetails getRomance() {
        return ROMANCE;
    }

    public ChiSymbolDetails getHealth() {
        return HEALTH;
    }

}

class ChiSymbolDetailsKey {
    private SnippetCode snippetCode;
    private ChiSymbol chiSymbol;

    public ChiSymbolDetailsKey(SnippetCode snippetCode, ChiSymbol chiSymbol) {
        this.snippetCode = snippetCode;
        this.chiSymbol = chiSymbol;
    }

    public SnippetCode getSnippetCode() {
        return snippetCode;
    }

    public ChiSymbol getChiSymbol() {
        return chiSymbol;
    }
}

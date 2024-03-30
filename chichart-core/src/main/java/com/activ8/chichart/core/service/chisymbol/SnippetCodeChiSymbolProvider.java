package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class SnippetCodeChiSymbolProvider {
    private static Map<SnippetCode, ChiSymbol> mappings = new HashMap<>();

    static {
        mappings.put(SnippetCode.A1, ChiSymbol.CAREER_BUSINESS);
        mappings.put(SnippetCode.A2, ChiSymbol.CAREER_BUSINESS);
        mappings.put(SnippetCode.A3, ChiSymbol.FAMILY_CREATIVITY);
        mappings.put(SnippetCode.A4, ChiSymbol.FAMILY_CREATIVITY);
        mappings.put(SnippetCode.A5, ChiSymbol.MONEY);
        mappings.put(SnippetCode.A6, ChiSymbol.MONEY);
        mappings.put(SnippetCode.A7, ChiSymbol.MAGNIFYING_GLASS);
        mappings.put(SnippetCode.A8, ChiSymbol.MAGNIFYING_GLASS);
        mappings.put(SnippetCode.A9, ChiSymbol.MONEY);
        mappings.put(SnippetCode.A10, ChiSymbol.MONEY);
        mappings.put(SnippetCode.A11, ChiSymbol.MAGNIFYING_GLASS);
        mappings.put(SnippetCode.A12, ChiSymbol.CAREER_BUSINESS);
        mappings.put(SnippetCode.A13, ChiSymbol.CAREER_BUSINESS);
        mappings.put(SnippetCode.A14, ChiSymbol.HEALTH);
        mappings.put(SnippetCode.A15, ChiSymbol.HEALTH);
        mappings.put(SnippetCode.A16, ChiSymbol.MAGNIFYING_GLASS);
        mappings.put(SnippetCode.A17, ChiSymbol.MAGNIFYING_GLASS);
        mappings.put(SnippetCode.A18, ChiSymbol.FAMILY_CREATIVITY);
        mappings.put(SnippetCode.A19, ChiSymbol.FAMILY_CREATIVITY);
        mappings.put(SnippetCode.A20, ChiSymbol.MONEY);
        mappings.put(SnippetCode.A21, ChiSymbol.MONEY);
    }

    public ChiSymbol getChiSymbol(SnippetCode snippetCode) {
        return mappings.get(snippetCode);
    }
}

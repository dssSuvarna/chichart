package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;

/**
 * The description related to a shi symbol is dependent on the associated snippet code (could be a good or bad code)
 * as well as whether its a special type of day (eg branch class, branch combo).
 */
public class ChiSymbolDetails {

    private ChiSymbol chiSymbol;
    private String description;

    public ChiSymbolDetails(ChiSymbol chiSymbol, String description) {
        this.chiSymbol = chiSymbol;
        this.description = description;
    }

    public ChiSymbol getChiSymbol() {
        return chiSymbol;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ChiSymbolDetails{" +
                "chiSymbol=" + chiSymbol +
                ", description='" + description + '\'' +
                '}';
    }
}

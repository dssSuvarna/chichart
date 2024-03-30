package com.activ8.chichart.core.service.rulers;

import com.activ8.chichart.core.domain.*;

/**
 * Ruler number = Day branch number - Month branch number + 1
 * eg
 * Month Day
 * ---------
 * Chou Chou = 2 - 2 + 1 = 1 FOUNDATION
 * Wu Mao = 4 - 7 + 1 = -2 (10) RECEIVE
 * You Shen = 9 - 10 + 1 = 0 (12) INSIGHTFUL
 * Chou You = 10 - 2 + 1 = 9 SUCCESS
 * You Chou = 2 - 10 + 1 = -7 (5) STABILITY
 */
public class TwelveRulersLogic {

    public Ruler getRuler(BranchType monthBranch, BranchType dayBranch) {
        int rulerOrder = dayBranch.getOrder() - monthBranch.getOrder() + 1;
        if (rulerOrder <= 0) {
            rulerOrder = 12 + rulerOrder;
        }

        return Ruler.fromOrder(rulerOrder);
    }
}

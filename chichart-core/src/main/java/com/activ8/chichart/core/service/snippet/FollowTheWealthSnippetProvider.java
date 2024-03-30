package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public class FollowTheWealthSnippetProvider extends AbstractSnippetProvider implements SnippetProvider {

    private static List<SnippetCode> stemMatrix = Arrays.asList(
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20,
            SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13,
            SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16
    );

    private static List<SnippetCode> branchMatrix = Arrays.asList(
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20,
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A3, SnippetCode.A4
    );

    FollowTheWealthSnippetProvider(SnippetLogic snippetLogic) {
        super(snippetLogic, stemMatrix, branchMatrix);
    }

    @Override
    public LunarMethodType getLunarMethodType() {
        return LunarMethodType.FOLLOW_WEALTH;
    }
}

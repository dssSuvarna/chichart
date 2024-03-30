package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public class FollowThePowerSnippetProvider extends AbstractSnippetProvider implements SnippetProvider {

    private static List<SnippetCode> stemMatrix = Arrays.asList(
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A18, SnippetCode.A19,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18,
            SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21,
            SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20,
            SnippetCode.A20, SnippetCode.A21, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A19, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13,
            SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16
    );

    private static List<SnippetCode> branchMatrix = Arrays.asList(
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18,
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10,
            SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18,
            SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A13, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A21, SnippetCode.A20,
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A20, SnippetCode.A21, SnippetCode.A18, SnippetCode.A19
    );

    FollowThePowerSnippetProvider(SnippetLogic snippetLogic) {
        super(snippetLogic, stemMatrix, branchMatrix);
    }

    @Override
    public LunarMethodType getLunarMethodType() {
        return LunarMethodType.FOLLOW_POWER;
    }
}

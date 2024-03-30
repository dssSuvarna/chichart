package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public class FollowTheResourceSnippetProvider extends AbstractSnippetProvider implements SnippetProvider {

    private static List<SnippetCode> stemMatrix = Arrays.asList(
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A5, SnippetCode.A6, SnippetCode.A11, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13,
            SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A9, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A10, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A11, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16
    );

    private static List<SnippetCode> branchMatrix = Arrays.asList(
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A10, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A9, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A11, SnippetCode.A11, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A10, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A17, SnippetCode.A16, SnippetCode.A10, SnippetCode.A9, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A9, SnippetCode.A10, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A11, SnippetCode.A11
    );

    FollowTheResourceSnippetProvider(SnippetLogic snippetLogic) {
        super(snippetLogic, stemMatrix, branchMatrix);
    }

    @Override
    public LunarMethodType getLunarMethodType() {
        return LunarMethodType.FOLLOW_RESOURCE;
    }
}

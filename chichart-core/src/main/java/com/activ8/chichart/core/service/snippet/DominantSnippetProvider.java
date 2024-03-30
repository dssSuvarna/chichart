package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public class DominantSnippetProvider extends AbstractSnippetProvider implements SnippetProvider {

    private static List<SnippetCode> stemMatrix = Arrays.asList(
            SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4,
            SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8,
            SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7,
            SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10,
            SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2,
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1
    );

    private static List<SnippetCode> branchMatrix = Arrays.asList(
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1,
            SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6,
            SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1,
            SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A5, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2,
            SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A10, SnippetCode.A9, SnippetCode.A8, SnippetCode.A7, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A1, SnippetCode.A2, SnippetCode.A9, SnippetCode.A10, SnippetCode.A7, SnippetCode.A8, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4
    );

    DominantSnippetProvider(SnippetLogic snippetLogic) {
        super(snippetLogic, stemMatrix, branchMatrix);
    }

    @Override
    public LunarMethodType getLunarMethodType() {
        return LunarMethodType.DOMINANT;
    }

    @Override
    public boolean matches(LunarMethodType lunarMethodType) {
        return lunarMethodType == LunarMethodType.DOMINANT || lunarMethodType == LunarMethodType.DOMINANT_EARTH;
    }

}

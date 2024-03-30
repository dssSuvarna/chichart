package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public class CompetitiveSnippetProvider extends AbstractSnippetProvider implements SnippetProvider {

    private static List<SnippetCode> stemMatrix = Arrays.asList(
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A3, SnippetCode.A4, SnippetCode.A11, SnippetCode.A11, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A11, SnippetCode.A11, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A11, SnippetCode.A11, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13,
            SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A11, SnippetCode.A11, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A14, SnippetCode.A3, SnippetCode.A4, SnippetCode.A11, SnippetCode.A1, SnippetCode.A14, SnippetCode.A15,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A11, SnippetCode.A11, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A11, SnippetCode.A11
    );

    private static List<SnippetCode> branchMatrix = Arrays.asList(
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6,
            SnippetCode.A2, SnippetCode.A1, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A1, SnippetCode.A2,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A15, SnippetCode.A14, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2, SnippetCode.A14, SnippetCode.A15,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A2, SnippetCode.A1, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4, SnippetCode.A1, SnippetCode.A2,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5, SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A4, SnippetCode.A3, SnippetCode.A2, SnippetCode.A1, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A6, SnippetCode.A5,
            SnippetCode.A2, SnippetCode.A1, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A5, SnippetCode.A6, SnippetCode.A3, SnippetCode.A4
    );

    CompetitiveSnippetProvider(SnippetLogic snippetLogic) {
        super(snippetLogic, stemMatrix, branchMatrix);
    }

    @Override
    public LunarMethodType getLunarMethodType() {
        return LunarMethodType.COMPETITIVE;
    }
}

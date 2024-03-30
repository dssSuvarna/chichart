package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.SnippetCode;
import com.activ8.chichart.core.service.lunarmethod.LunarMethodType;

import java.util.Arrays;
import java.util.List;

public class UnknownSnippetProvider extends AbstractSnippetProvider implements SnippetProvider {

    private static List<SnippetCode> stemMatrix = Arrays.asList(
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18,
            SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13,
            SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15,
            SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16
    );

    private static List<SnippetCode> branchMatrix = Arrays.asList(
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18,
            SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16,
            SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15,
            SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11, SnippetCode.A19, SnippetCode.A18,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19, SnippetCode.A16, SnippetCode.A17,
            SnippetCode.A19, SnippetCode.A18, SnippetCode.A17, SnippetCode.A16, SnippetCode.A15, SnippetCode.A14, SnippetCode.A13, SnippetCode.A12, SnippetCode.A11, SnippetCode.A11,
            SnippetCode.A16, SnippetCode.A17, SnippetCode.A14, SnippetCode.A15, SnippetCode.A12, SnippetCode.A13, SnippetCode.A11, SnippetCode.A11, SnippetCode.A18, SnippetCode.A19
    );

    UnknownSnippetProvider(SnippetLogic snippetLogic) {
        super(snippetLogic, stemMatrix, branchMatrix);
    }

    @Override
    public LunarMethodType getLunarMethodType() {
        return LunarMethodType.UNKNOWN;
    }
}

package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;
import org.junit.*;

import java.time.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ElementRankLogicTest extends AbstractUnitTest {

    private ElementRankLogic elementRankLogic = ServiceFactory.getInstance().getElementRankLogic();

    private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

    private LunarMethodService lunarMethodService = ServiceFactory.getInstance().getLunarMethodService();

    private LocalDate dob = LocalDate.of(1939, 7, 26);
    private LocalTime timeOfBirth = LocalTime.of(2,21);

    @Test
    public void johnHowardStems() {

        FourPillarsChart chart = fourPillarsService.getPillars(dob, timeOfBirth);
        LunarMethod lunarMethod = lunarMethodService.getLunarMethod(new LunarMethodCommand(chart, dob, Gender.MALE, LocalDate.now()));
        List<ElementType> rankedElements = lunarMethodService.getRankedElements(lunarMethod.getType(), chart.getDayPillar().getStem().getElement());
        List<RankedStem> rankedStems = elementRankLogic.rankStems(chart, lunarMethod, rankedElements);

        assertThat(getStem(StemType.REN, rankedStems).getScore()).isEqualTo(Score.GOOD);
        assertThat(getStem(StemType.GUI, rankedStems).getScore()).isEqualTo(Score.GOOD);
        assertThat(getStem(StemType.JIA, rankedStems).getScore()).isEqualTo(Score.GOOD);
        assertThat(getStem(StemType.YI, rankedStems).getScore()).isEqualTo(Score.GOOD);

        assertThat(getStem(StemType.BING, rankedStems).getScore()).isEqualTo(Score.AVERAGE);
        assertThat(getStem(StemType.DING, rankedStems).getScore()).isEqualTo(Score.AVERAGE);

        assertThat(getStem(StemType.WU, rankedStems).getScore()).isEqualTo(Score.BAD);
        assertThat(getStem(StemType.JI, rankedStems).getScore()).isEqualTo(Score.BAD);
        assertThat(getStem(StemType.GENG, rankedStems).getScore()).isEqualTo(Score.BAD);
        assertThat(getStem(StemType.XIN, rankedStems).getScore()).isEqualTo(Score.BAD);

    }

    @Test
    public void johnHowardBranches() {

        FourPillarsChart chart = fourPillarsService.getPillars(dob, timeOfBirth);
        LunarMethod lunarMethod = lunarMethodService.getLunarMethod(new LunarMethodCommand(chart, dob, Gender.MALE, LocalDate.now()));
        List<ElementType> rankedElements = lunarMethodService.getRankedElements(lunarMethod.getType(), chart.getDayPillar().getStem().getElement());
        List<RankedBranch> rankedBranches = elementRankLogic.rankBranches(chart, lunarMethod, rankedElements);

        assertThat(getBranch(BranchType.ZI, rankedBranches).getScore()).isEqualTo(Score.GOOD);
        assertThat(getBranch(BranchType.HAI, rankedBranches).getScore()).isEqualTo(Score.GOOD);
        assertThat(getBranch(BranchType.YIN, rankedBranches).getScore()).isEqualTo(Score.GOOD);
        assertThat(getBranch(BranchType.MAO, rankedBranches).getScore()).isEqualTo(Score.GOOD);

        assertThat(getBranch(BranchType.SI, rankedBranches).getScore()).isEqualTo(Score.AVERAGE);
        assertThat(getBranch(BranchType.WU, rankedBranches).getScore()).isEqualTo(Score.AVERAGE);

        assertThat(getBranch(BranchType.CHOU, rankedBranches).getScore()).isEqualTo(Score.BAD);
        assertThat(getBranch(BranchType.CHEN, rankedBranches).getScore()).isEqualTo(Score.BAD);
        assertThat(getBranch(BranchType.WEI, rankedBranches).getScore()).isEqualTo(Score.GOOD);
        assertThat(getBranch(BranchType.WEI, rankedBranches).getScoreReason()).isEqualTo(ScoreReason.COMBINATION_HARMONY);
        assertThat(getBranch(BranchType.XU, rankedBranches).getScore()).isEqualTo(Score.BAD);
        assertThat(getBranch(BranchType.SHEN, rankedBranches).getScore()).isEqualTo(Score.BAD);
        assertThat(getBranch(BranchType.YOU, rankedBranches).getScore()).isEqualTo(Score.BAD);
    }

    private RankedStem getStem(StemType stemType, List<RankedStem> rankedStems) {
        for (RankedStem rs : rankedStems) {
            if (rs.getStemType().equals(stemType)) {
                return rs;
            }
        }
        return null;
    }

    private RankedBranch getBranch(BranchType branchType, List<RankedBranch> rankedBranches) {
        for (RankedBranch rb : rankedBranches) {
            if (rb.getBranchType().equals(branchType)) {
                return rb;
            }
        }
        return null;

    }

}
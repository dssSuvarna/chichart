package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.*;
import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;
import org.junit.*;

import java.time.*;

import static org.assertj.core.api.Assertions.*;

public class LunarMethodTest extends AbstractUnitTest {

    private FourPillarsService fourPillarsService = ServiceFactory.getInstance().getFourPillarsService();

    private LunarMethodService lunarMethodService = ServiceFactory.getInstance().getLunarMethodService();

    private void assertTest(LocalDate dob, LocalTime tob, Gender gender, LunarMethodType lunarMethodType) {
        assertTest(dob, tob, LocalDate.now(), gender, lunarMethodType);
    }

    private void assertTest(LocalDate dob, LocalTime tob, LocalDate chartDate, Gender gender, LunarMethodType lunarMethodType) {
        FourPillarsChart chart = fourPillarsService.getPillars(dob, tob);
        assertThat(lunarMethodService.getLunarMethod(new LunarMethodCommand(chart, dob, gender, chartDate)).getType()).isEqualTo(lunarMethodType);
    }

    @Test
    public void test_isDominant_JohnHoward() {
        assertTest(LocalDate.of(1939, 7, 26), LocalTime.of(2,21), Gender.MALE, LunarMethodType.DOMINANT);
    }

    @Test
    public void test_isDominant_SharonStone() {
        assertTest(LocalDate.of(1958, 3, 10), LocalTime.of(4,52), Gender.FEMALE, LunarMethodType.DOMINANT);
    }

    @Test
    public void test_isDominantEarth_Sade() {
        assertTest(LocalDate.of(1959, 1, 16), null, Gender.FEMALE, LunarMethodType.DOMINANT_EARTH);
    }

    @Test
    public void test_isCompetitive_NicholasCage() {
        assertTest(LocalDate.of(1964, 1, 7), LocalTime.of(5,30), Gender.MALE, LunarMethodType.COMPETITIVE);
    }

    @Test
    public void test_isFollowThePower() {
        // faye dunnaway
        assertTest(LocalDate.of(1941, 1, 14), LocalTime.of(8,15), Gender.FEMALE, LunarMethodType.FOLLOW_POWER);

        // oscar pistorius
        assertTest(LocalDate.of(1986, 11, 22), LocalTime.of(10,30), Gender.MALE, LunarMethodType.FOLLOW_POWER);
    }

    @Test
    public void test_isFollowTheWealth() {
        // pedro
        assertTest(LocalDate.of(1949, 9, 24), LocalTime.of(22,0), Gender.MALE, LunarMethodType.FOLLOW_WEALTH);

        // paul mccartney
        assertTest(LocalDate.of(1942, 6, 18), LocalTime.of(2,0), Gender.MALE, LunarMethodType.FOLLOW_WEALTH);
    }

    //@Test
    public void test_isFollowTheOutput() {

        // prince charles
        assertTest(LocalDate.of(1948, 11, 14), LocalTime.of(21,14), Gender.MALE, LunarMethodType.FOLLOW_OUTPUT);

        // will smith
        assertTest(LocalDate.of(1968, 9, 25), LocalTime.of(1,46), Gender.MALE, LunarMethodType.FOLLOW_OUTPUT);
    }

    //@Test
    public void test_isFollowTheResource() {

        // tina turner
        assertTest(LocalDate.of(1939, 11, 26), LocalTime.of(22,10), Gender.FEMALE, LunarMethodType.FOLLOW_RESOURCE);

        // liv tyler
        assertTest(LocalDate.of(1977, 1, 7), LocalTime.of(6,8), Gender.FEMALE, LunarMethodType.FOLLOW_RESOURCE);
    }

    @Test
    public void test_isDominant_secondPass() {
        assertTest(LocalDate.of(1993, 1, 14), LocalTime.of(11,0), Gender.MALE, LunarMethodType.FOLLOW_RESOURCE);
    }

    //@Test
    public void test_isDominant_glen_whenOlderThan40() {
        assertTest(LocalDate.of(1966, 1, 22), LocalTime.of(17,45), Gender.MALE, LunarMethodType.DOMINANT);
    }

    //@Test
    public void test_isFollowPower_glen_whenYoungerThan40() {
        assertTest(LocalDate.of(1966, 1, 22), LocalTime.of(17,45), LocalDate.of(2000, 1, 1), Gender.MALE, LunarMethodType.FOLLOW_POWER);
    }

}

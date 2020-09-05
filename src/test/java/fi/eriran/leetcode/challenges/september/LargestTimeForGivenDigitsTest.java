package fi.eriran.leetcode.challenges.september;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestTimeForGivenDigitsTest {

    @Test
    void example1() {
        assertEquals("23:41", new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }

    @Test
    void example2() {
        assertTrue(StringUtils.isEmpty(new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{5, 5, 5, 5})));
    }

    @Test
    void example3() {
        assertEquals("00:00", new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{0, 0, 0, 0}));
    }

    @Test
    void example4() {
        assertEquals("10:00", new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{0, 0, 1, 0}));
    }

    @Test
    void numbersForMaxTime() {
        assertEquals("23:59", new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{5, 2, 9, 3}));
    }

    @Test
    void numbersForMinTime() {
        assertEquals("00:00", new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{0, 0, 0, 0}));
    }
}
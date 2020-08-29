package fi.eriran.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void example1() {
        assertEquals(6, new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void submissionTest1() {
        assertEquals(3, new TrappingRainWater().trap(new int[]{4, 2, 3}));
    }
}
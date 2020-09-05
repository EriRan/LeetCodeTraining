package fi.eriran.leetcode.problemset.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void example1() {
        assertEquals(6, new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void submissionTest1() {
        assertEquals(1, new TrappingRainWater().trap(new int[]{4, 2, 3}));
    }

    @Test
    void submissionTest2() {
        assertEquals(23, new TrappingRainWater().trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }

    @Test
    void submissionTest3() {
        assertEquals(2, new TrappingRainWater().trap(new int[]{2,0,2}));
    }
}
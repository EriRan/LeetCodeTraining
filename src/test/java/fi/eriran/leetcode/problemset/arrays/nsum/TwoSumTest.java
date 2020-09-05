package fi.eriran.leetcode.problemset.arrays.nsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TwoSumTest {

    @Test
    void example1() {
        int[] response = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(0, response[0]);
        assertEquals(1, response[1]);
    }

    @Test
    void submissionTest1() {
        int[] response = new TwoSum().twoSum(new int[]{3,3}, 6);
        assertNotNull(response);
        assertEquals(0, response[0]);
        assertEquals(1, response[1]);
    }

    @Test
    void submissionTest2() {
        int[] response = new TwoSum().twoSum(new int[]{3,2,4}, 6);
        assertNotNull(response);
        assertEquals(1, response[0]);
        assertEquals(2, response[1]);
    }

    @Test
    void submissionTest3() {
        int[] response = new TwoSum().twoSum(new int[]{2,5,5,11}, 10);
        assertNotNull(response);
        assertEquals(1, response[0]);
        assertEquals(2, response[1]);
    }
}
package fi.eriran.leetcode.problemset.arrays;

import fi.eriran.leetcode.problemset.matrix.MergeIntervals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void example1() {
        int[][] input = create2dArray(Arrays.asList(1,3,2,6,8,10,15,18));
        int[][] response = new MergeIntervals().merge(input);
        assertEquals(3, response.length);
        int[][] expectedResult = create2dArray(Arrays.asList(1, 6, 8, 10, 15, 18));
        assertArrayEquals(
                expectedResult,
                response
        );
    }

    @Test
    void example2() {
        int[][] input = create2dArray(Arrays.asList(1,4,4,5));
        int[][] response = new MergeIntervals().merge(input);
        assertEquals(1, response.length);
        int[][] expectedResult = create2dArray(Arrays.asList(1,5));
        assertArrayEquals(
                expectedResult,
                response
        );
    }

    private int[][] create2dArray(List<Integer> asList) {
        int[][] input = new int[asList.size() / 2][2];
        for (int i = 0; i < asList.size() / 2; i++) {
            input[i][0] = asList.get(i * 2);
            input[i][1] = asList.get((i * 2) + 1);
        }
        return input;
    }
}
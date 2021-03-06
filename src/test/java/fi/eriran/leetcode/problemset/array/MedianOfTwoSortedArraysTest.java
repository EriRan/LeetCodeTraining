package fi.eriran.leetcode.problemset.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    @Test
    void exampleOne() {
        assertEquals(2.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
    }

    @Test
    void exampleTwo() {
        assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }

    @Test
    void oneInt() {
        assertEquals(6.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {}, new int[] {6}));
    }

    @Test
    void oneArrayEmptyEven() {
        assertEquals(3.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {}, new int[] {1,2,4,6}));
    }

    @Test
    void oneArrayEmptyOdd() {
        assertEquals(2.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1,2,4}, new int[] {}));
    }

    @Test
    void oneArrayEmptyTwoValues() {
        assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {2,3}, new int[] {}));
    }
}
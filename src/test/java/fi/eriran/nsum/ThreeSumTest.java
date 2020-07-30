package fi.eriran.nsum;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {


    @Test
    public void testExample() {
        List<List<Integer>> response = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertFalse(CollectionUtils.isEmpty(response));
        assertEquals(2, response.size());
        assertTrue(response.contains(Arrays.asList(-1, 0, 1)));
        assertTrue(response.contains(Arrays.asList(-1, -1, 2)));
    }

    @Test
    public void testLargeInput() {
        List<List<Integer>> response = new ThreeSum().threeSum(new int[]{
                -7, -10, -1, 3, 0, -7, -9, -1, 10, 8, -6, 4, 14, -8, 9, -15, 0, -4, -5, 9, 11, 3, -5, -8, 2, -6, -14, 7, -14, 10, 5, -6, 7, 11, 4, -7, 11
                , 11, 7, 7, -4, -14, -12, -13, -14, 4, -13, 1, -15, -2, -12, 11, -14, -2, 10, 3, -1, 11, -5, 1, -2, 7, 2, -10, -5, -8, -10, 14, 10, 13,
                -2, -9, 6, -7, -7, 7, 12, -5, -14, 4, 0, -11, -8, 2, -6, -13, 12, 0, 5, -15, 8, -12, -1, -4, -15, 2, -5, -9, -7, 12, 11, 6, 10, -6, 14,
                -12, 9, 3, -10, 10, -8, -2, 6, -9, 7, 7, -7, 4, -8, 5, -4, 8, 0, 3, 11, 0, -10, -9});
        assertFalse(CollectionUtils.isEmpty(response));
    }

    @Test
    public void testLength2ReturnsEmpty() {
        assertTrue(CollectionUtils.isEmpty(new ThreeSum().threeSum(new int[]{-1, 0})));
    }
}
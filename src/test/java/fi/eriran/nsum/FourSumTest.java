package fi.eriran.nsum;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {

    @Test
    void example1() {
        List<List<Integer>> lists = new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        assertFalse(CollectionUtils.isEmpty(lists));
        assertEquals(3, lists.size());
        assertTrue(lists.contains(Arrays.asList(-1, 0, 0, 1)));
        assertTrue(lists.contains(Arrays.asList(-2, -1, 1, 2)));
        assertTrue(lists.contains(Arrays.asList(-2, 0, 0, 2)));
    }

    @Test
    void zeroesInput() {
        List<List<Integer>> lists = new FourSum().fourSum(new int[]{0, 0, 0, 0}, 0);
        assertFalse(CollectionUtils.isEmpty(lists));
        assertEquals(1, lists.size());
        assertTrue(lists.contains(Arrays.asList(0, 0, 0, 0)));
    }

    @Test
    void submissionTest1() {
        List<List<Integer>> lists = new FourSum().fourSum(new int[]{-7, -5, 0, 7, 1, 1, -10, -2, 7, 7, -2, -6, 0, -10, -5, 7, -8, 5}, 28);
        assertFalse(CollectionUtils.isEmpty(lists));
        assertEquals(1, lists.size());
        assertTrue(lists.contains(Arrays.asList(7,7,7,7)));
    }
}
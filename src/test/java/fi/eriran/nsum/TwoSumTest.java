package fi.eriran.nsum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TwoSumTest {

    @Test
    public void testExample() {
        int[] response = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(0, response[0]);
        assertEquals(1, response[1]);
    }

    @Test
    public void testAfterSubmitOne() {
        int[] response = new TwoSum().twoSum(new int[]{3,3}, 6);
        assertNotNull(response);
        assertEquals(0, response[0]);
        assertEquals(1, response[1]);
    }

    @Test
    public void testAfterSubmitTwo() {
        int[] response = new TwoSum().twoSum(new int[]{3,2,4}, 6);
        assertNotNull(response);
        assertEquals(1, response[0]);
        assertEquals(2, response[1]);
    }

    @Test
    public void testAfterSubmitThree() {
        int[] response = new TwoSum().twoSum(new int[]{2,5,5,11}, 10);
        assertNotNull(response);
        assertEquals(1, response[0]);
        assertEquals(2, response[1]);
    }
}
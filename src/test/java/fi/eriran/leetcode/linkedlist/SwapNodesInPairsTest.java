package fi.eriran.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {

    private final ListNodeTestObjectGenerator testObjectGenerator;

    public SwapNodesInPairsTest() {
        testObjectGenerator = new ListNodeTestObjectGenerator();
    }

    @Test
    void example1() {
        int[] values = {1, 2, 3, 4};
        validateOrder(new int[]{2, 1, 4, 3},
                new SwapNodesInPairs().swapPairs(testObjectGenerator.create(values)));
    }

    @Test
    void threeValues() {
        int[] values = {1, 2, 3};
        validateOrder(new int[]{2, 1, 3},
                new SwapNodesInPairs().swapPairs(testObjectGenerator.create(values)));
    }

    private void validateOrder(int[] expectedOrder, ListNode firstNode) {
        assertNotNull(firstNode);
        ListNode currentNode = firstNode;
        int currentExpectedOrderIndex = 0;
        while (currentNode != null) {
            assertTrue(currentExpectedOrderIndex < expectedOrder.length, "Invalid expected order size");
            assertEquals(expectedOrder[currentExpectedOrderIndex], currentNode.val);
            currentExpectedOrderIndex++;
            currentNode = currentNode.next;
        }
    }
}
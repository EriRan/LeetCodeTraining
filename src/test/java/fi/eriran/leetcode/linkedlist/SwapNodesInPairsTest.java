package fi.eriran.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {

    @Test
    void example1() {
        int[] values = {1, 2, 3, 4};
        validateOrder(new int[]{2, 1, 4, 3},
                new SwapNodesInPairs().swapPairs(createListNodeLinkedList(values)));
    }

    private SwapNodesInPairs.ListNode createListNodeLinkedList(int... numbers) {
        SwapNodesInPairs.ListNode firstNode = new SwapNodesInPairs.ListNode(numbers[0]);
        SwapNodesInPairs.ListNode previous = firstNode;
        for (int i = 1; i < numbers.length; i++) {
            SwapNodesInPairs.ListNode newNode = new SwapNodesInPairs.ListNode(numbers[i]);
            previous.next = newNode;
            previous = newNode;
        }
        return firstNode;
    }

    private void validateOrder(int[] expectedOrder, SwapNodesInPairs.ListNode firstNode) {
        assertNotNull(firstNode);
        SwapNodesInPairs.ListNode currentNode = firstNode;
        int currentExpectedOrderIndex = 0;
        while (currentNode != null) {
            assertTrue(currentExpectedOrderIndex < expectedOrder.length, "Invalid expected order size");
            assertEquals(expectedOrder[currentExpectedOrderIndex], currentNode.val);
            currentExpectedOrderIndex++;
            currentNode = currentNode.next;
        }
    }
}
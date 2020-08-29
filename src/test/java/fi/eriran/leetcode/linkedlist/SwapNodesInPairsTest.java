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

    @Test
    void threeValues() {
        int[] values = {1, 2, 3};
        validateOrder(new int[]{2, 1, 3},
                new SwapNodesInPairs().swapPairs(createListNodeLinkedList(values)));
    }

    private ListNode createListNodeLinkedList(int... numbers) {
        ListNode firstNode = new ListNode(numbers[0]);
        ListNode previous = firstNode;
        for (int i = 1; i < numbers.length; i++) {
            ListNode newNode = new ListNode(numbers[i]);
            previous.next = newNode;
            previous = newNode;
        }
        return firstNode;
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
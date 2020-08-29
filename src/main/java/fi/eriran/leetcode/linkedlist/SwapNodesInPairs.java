package fi.eriran.leetcode.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("Null input not allowed");
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

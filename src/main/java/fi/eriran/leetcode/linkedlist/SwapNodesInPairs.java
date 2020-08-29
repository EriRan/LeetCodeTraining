package fi.eriran.leetcode.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        //Shortcuts
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        return performSwapping(head);
    }

    private ListNode performSwapping(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;
        ListNode previousSetLast = null;
        head = nextNode;
        while (nextNode != null) {
            //Current node is made to point the next of the next
            //Next node is made to point the current node
            //Previous set last is made to point the next node
            ListNode nextOfPreviousNext = nextNode.next;
            nextNode.next = currentNode;
            currentNode.next = nextOfPreviousNext;

            if (previousSetLast != null) {
                previousSetLast.next = nextNode;
                previousSetLast = currentNode;
            } else {
                previousSetLast = currentNode;
            }

            currentNode = nextOfPreviousNext;
            if (nextOfPreviousNext != null) {
                nextNode = nextOfPreviousNext.next;
            } else {
                return head;
            }
        }
        return head;
    }
}

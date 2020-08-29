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
        ListNode previousNode = null;
        head = currentNode.next;
        while (currentNode != null && currentNode.next != null) {
            //Current node is made to point the next of the next
            //Next node is made to point the current node
            //Previous set last is made to point the next node
            ListNode nextNode = currentNode.next;
            ListNode nextOfNext = getNextOfNext(currentNode);
            nextNode.next = currentNode;
            currentNode.next = nextOfNext;

            if (previousNode != null) {
                previousNode.next = nextNode;
            }
            previousNode = currentNode;
            currentNode = nextOfNext;
        }
        return head;
    }

    private ListNode getNextOfNext(ListNode currentNode) {
        //While condition has currentNode.next != null so we can directly get next of the next
        if (currentNode.next.next != null) {
            return currentNode.next.next;
        }
        return null;
    }
}

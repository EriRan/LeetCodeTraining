package fi.eriran.leetcode.problemset.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode listNodeOne, ListNode listNodeTwo) {
        if (listNodeOne == null || listNodeTwo == null) {
            return null;
        }
        ListNode listNodeHead = new ListNode();
        createNextNode(listNodeOne, listNodeTwo, listNodeHead, false);
        return listNodeHead;
    }

    private void createNextNode(ListNode listNodeOne,
                                ListNode listNodeTwo,
                                ListNode currentListNode,
                                boolean overflow) {
        //Add the two values together
        int combinedValue = getCombinedValue(
                getListNodeValue(listNodeOne),
                getListNodeValue(listNodeTwo),
                overflow
        );
        overflow = false;

        //Add combined value to the current node
        if (combinedValue > 9) {
            currentListNode.val = combinedValue - 10;
            overflow = true;
        } else {
            currentListNode.val = combinedValue;
        }

        //Move pointers
        ListNode nextOneNode = getNextOrNull(listNodeOne);
        ListNode nextTwoNode = getNextOrNull(listNodeTwo);
        if (nextOneNode == null && nextTwoNode == null) {
            if (overflow) {
                currentListNode.next = new ListNode(1);
            }
        } else {
            currentListNode.next = new ListNode();
            createNextNode(nextOneNode, nextTwoNode, currentListNode.next, overflow);
        }
    }

    private ListNode getNextOrNull(ListNode listNodeOne) {
        if (listNodeOne == null) {
            return null;
        }
        return listNodeOne.next;
    }

    private int getCombinedValue(Integer listNodeOneValue, Integer listNodeTwoValue, boolean overflow) {
        if (overflow) {
            return combineTwoValues(listNodeOneValue, listNodeTwoValue) + 1;
        }
        return combineTwoValues(listNodeOneValue, listNodeTwoValue);
    }

    private int combineTwoValues(Integer listNodeOneValue, Integer listNodeTwoValue) {
        if (listNodeOneValue != null && listNodeTwoValue != null) {
            return listNodeOneValue + listNodeTwoValue;
        } else if (listNodeOneValue != null) {
            return listNodeOneValue;
        } else {
            return listNodeTwoValue;
        }
    }

    private Integer getListNodeValue(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        return listNode.val;
    }
}

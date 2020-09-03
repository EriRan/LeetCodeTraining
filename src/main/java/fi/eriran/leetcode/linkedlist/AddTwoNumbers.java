package fi.eriran.leetcode.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode listNodeOne, ListNode listNodeTwo) {
        ListNode addedTwoNumbersHead = new ListNode();
        ListNode addedTwoNumbers = addedTwoNumbersHead;
        boolean overflow = false;
        while (listNodeOne != null || listNodeTwo != null) {
            Integer listNodeOneValue = getListNodeValue(listNodeOne);
            Integer listNodeTwoValue = getListNodeValue(listNodeTwo);
            int combinedValue;
            if (overflow) {
                combinedValue = getCombinedValue(listNodeOneValue, listNodeTwoValue) + 1;
                overflow = false;
            } else {
                combinedValue = getCombinedValue(listNodeOneValue, listNodeTwoValue);
            }
            if (combinedValue > 9) {
                addedTwoNumbers.val = combinedValue - 10;
                overflow = true;
            } else {
                addedTwoNumbers.val = combinedValue;
            }

            //Move pointers

            boolean doContinue = false;

            if (listNodeOne != null) {
                listNodeOne = listNodeOne.next;
                doContinue = listNodeOne != null;
            }
            if (listNodeTwo != null) {
                listNodeTwo = listNodeTwo.next;
                doContinue = doContinue || listNodeTwo != null;
            }
            if (doContinue) {
                addedTwoNumbers.next = new ListNode();
                addedTwoNumbers = addedTwoNumbers.next;
            } else if (overflow) {
                addedTwoNumbers.next = new ListNode(1);
            }
        }
        return addedTwoNumbersHead;
    }

    private int getCombinedValue(Integer listNodeOneValue, Integer listNodeTwoValue) {
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

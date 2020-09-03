package fi.eriran.leetcode.linkedlist;

public class ListNodeTestObjectGenerator {

    public ListNode create(int... numbers) {
        ListNode firstNode = new ListNode(numbers[0]);
        ListNode previous = firstNode;
        for (int i = 1; i < numbers.length; i++) {
            ListNode newNode = new ListNode(numbers[i]);
            previous.next = newNode;
            previous = newNode;
        }
        return firstNode;
    }
}

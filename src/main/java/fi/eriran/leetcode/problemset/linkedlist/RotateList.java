package fi.eriran.leetcode.problemset.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        k = deduceRealAmountOfRotationsNeeded(countSize(head), k);
        //Find first, tail and the one before tail
        ListNode first = head;
        ListNode previous = head;
        ListNode tail = head;
        int currentIterations = 0;
        while (currentIterations < k) {
            while (tail.next != null) {
                previous = tail;
                tail = tail.next;
            }
            //Move next pointers
            previous.next = null;
            tail.next = first;
            //The previous last is now the first
            first = tail;
            currentIterations++;
        }


        return first;
    }

    private int deduceRealAmountOfRotationsNeeded(int countSize, int rotationsRequested) {
        return rotationsRequested % countSize;
    }

    private int countSize(ListNode head) {
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        return size;
    }
}

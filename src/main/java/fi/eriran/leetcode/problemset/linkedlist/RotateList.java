package fi.eriran.leetcode.problemset.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        //Find first, tail and the one before tail
        ListNode first = head;
        ListNode previous = head;
        ListNode tail = head;
        boolean sizeCounted = false;
        int size = 1;
        int currentIterations = 0;
        while (currentIterations < k) {
            while (tail.next != null) {
                previous = tail;
                tail = tail.next;
                if (!sizeCounted) {
                    size++;
                }
            }
            //Optimize the real count of rotations needed
            if (!sizeCounted) {
                k = k % size;
                //If k is zero, we should stop rotating right away!
                if (k == 0) {
                    return head;
                }
            }
            //Move next pointers
            previous.next = null;
            tail.next = first;
            //The previous last is now the first
            first = tail;
            sizeCounted = true;
            currentIterations++;
        }

        return first;
    }
}

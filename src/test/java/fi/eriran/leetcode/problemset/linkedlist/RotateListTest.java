package fi.eriran.leetcode.problemset.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateListTest {

    @Test
    void example1() {
        ListNode currentNode = new RotateList()
                .rotateRight(new ListNodeTestObjectGenerator().create(1, 2, 3, 4, 5), 2);
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    assertEquals(4, currentNode.val);
                    break;
                case 1:
                    assertEquals(5, currentNode.val);
                    break;
                case 2:
                    assertEquals(1, currentNode.val);
                    break;
                case 3:
                    assertEquals(2, currentNode.val);
                    break;
                case 4:
                    assertEquals(3, currentNode.val);
                    break;
                default:
                    throw new IllegalStateException("Unexpected index");
            }
            currentNode = currentNode.next;
        }
    }

    @Test
    void example2() {
        ListNode currentNode = new RotateList()
                .rotateRight(new ListNodeTestObjectGenerator().create(0,1,2), 4);
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    assertEquals(2, currentNode.val);
                    break;
                case 1:
                    assertEquals(0, currentNode.val);
                    break;
                case 2:
                    assertEquals(1, currentNode.val);
                    break;
                default:
                    throw new IllegalStateException("Unexpected index");
            }
            currentNode = currentNode.next;
        }
    }

    @Test
    void singleRotationWith2Nodes() {
        ListNode currentNode = new RotateList()
                .rotateRight(new ListNodeTestObjectGenerator().create(1,2), 2);
        for (int i = 0; i < 2; i++) {
            switch (i) {
                case 0:
                    assertEquals(1, currentNode.val);
                    break;
                case 1:
                    assertEquals(2, currentNode.val);
                    break;
                default:
                    throw new IllegalStateException("Unexpected index");
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * If the amount of rotates can be divided with a modulo of zero, the rotation will not change the node at all.
     */
    @Test
    void hugeNumberOfRotatesSkipped() {
        ListNode currentNode = new RotateList()
                .rotateRight(new ListNodeTestObjectGenerator().create(1, 2, 3), 2000000000);
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    assertEquals(2, currentNode.val);
                    break;
                case 1:
                    assertEquals(3, currentNode.val);
                    break;
                case 2:
                    assertEquals(1, currentNode.val);
                    break;
                default:
                    throw new IllegalStateException("Unexpected index: " + i);
            }
            currentNode = currentNode.next;
        }
    }
}
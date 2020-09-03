package fi.eriran.leetcode.linkedlist;

public class ListNodeUtil {

    private ListNodeUtil() {
    }

    public static String getValuesAsOneString(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while(head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return stringBuilder.toString();
    }
}

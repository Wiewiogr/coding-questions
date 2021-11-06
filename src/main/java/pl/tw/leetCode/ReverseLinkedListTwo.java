package pl.tw.leetCode;

import pl.tw.random.datastructures.ListNode;

public class ReverseLinkedListTwo {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

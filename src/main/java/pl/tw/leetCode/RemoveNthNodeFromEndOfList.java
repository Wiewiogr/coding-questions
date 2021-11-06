package pl.tw.leetCode;

import pl.tw.random.datastructures.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode left = dummyHead;
        ListNode right = dummyHead;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummyHead.next;
    }

}

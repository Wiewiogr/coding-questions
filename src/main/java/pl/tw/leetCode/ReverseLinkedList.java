package pl.tw.leetCode;

import java.util.LinkedList;

public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode current = stack.pop();
        ListNode newHead = current;
        while(!stack.isEmpty()) {
            ListNode newNode = stack.pop();
            current.next = newNode;
            current = newNode;
        }
        current.next = null;
        return newHead;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package pl.tw.dailycodingquestion.num21to30;

/**
 * Given a singly linked list and an integer k, remove the kth last element from the list.
 * k is guaranteed to be smaller than the length of the list.
 * <p>
 * The list is very long, so making more than one pass is prohibitively expensive.
 * <p>
 * Do this in constant space and in one pass.
 */
public class CodingQuestion26 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(head);
        removeNthFromEnd(head, 2);
        print(head);
    }

    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode current = head;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        ListNode nodeBeforeTarget = dummyNode;

        while (current != null) {
            current = current.next;
            nodeBeforeTarget = nodeBeforeTarget.next;
        }

        nodeBeforeTarget.next = nodeBeforeTarget.next.next;

        return dummyNode.next;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

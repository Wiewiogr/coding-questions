package pl.tw.dailycodingquestion.num11to20;

import pl.tw.random.datastructures.ListNode;

/**
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * <p>
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * <p>
 * In this example, assume nodes with the same value are the exact same node objects.
 * <p>
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class CodingQuestion20 {

    public static void main(String[] args) {
        ListNode commonPart = new ListNode(8);
        commonPart.next = new ListNode(10);

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = commonPart;

        ListNode b = new ListNode(99);
        b.next = new ListNode(1);
        b.next.next = commonPart;

        System.out.println(intersectingNode(a, b));
    }

    public static int intersectingNode(ListNode a, ListNode b) {
        int sizeA = computeLength(a);
        int sizeB = computeLength(b);

        int diff = Math.abs(sizeA - sizeB);

        ListNode aPtr = a;
        ListNode bPtr = b;

        if (sizeA > sizeB) {
            for (int i = 0; i < diff; i++) {
                aPtr = aPtr.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                bPtr = bPtr.next;
            }
        }

        for (int i = 0; i < sizeA - diff; i++) {
            if (aPtr.val == bPtr.val) {
                return aPtr.val;
            } else {
                aPtr = aPtr.next;
                bPtr = bPtr.next;
            }
        }

        return -1;
    }

    private static int computeLength(ListNode node) {
        int length = 0;
        ListNode cur = node;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }
}

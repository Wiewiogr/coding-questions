package pl.tw.dailycodingquestion.num11to20;

import pl.tw.random.datastructures.LLNode;

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
        LLNode commonPart = new LLNode(8);
        commonPart.next = new LLNode(10);

        LLNode a = new LLNode(3);
        a.next = new LLNode(7);
        a.next.next = commonPart;

        LLNode b = new LLNode(99);
        b.next = new LLNode(1);
        b.next.next = commonPart;

        System.out.println(intersectingNode(a, b));
    }

    public static int intersectingNode(LLNode a, LLNode b) {
        int sizeA = computeLength(a);
        int sizeB = computeLength(b);

        int diff = Math.abs(sizeA - sizeB);

        LLNode aPtr = a;
        LLNode bPtr = b;

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

    private static int computeLength(LLNode node) {
        int length = 0;
        LLNode cur = node;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }
}

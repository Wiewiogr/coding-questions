package pl.tw.dailycodingquestion;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array,
 * compute the maximum values of each subarray of length k.
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 *
 *     10 = max(10, 5, 2)
 *     7 = max(5, 2, 7)
 *     8 = max(2, 7, 8)
 *     8 = max(7, 8, 7)
 *
 * Do this in O(n) time and O(k) space.
 * You can modify the input array in-place and you do not need to store the results.
 * You can simply print them out as you compute them.
 */

public class CodingQuestion18 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{10, 5, 2, 7, 8, 8}, 3)));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[]{};
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {

            // remove from head if is out of current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // remove lesser values from deque, because they have no chance to become max
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                System.out.println(i);
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }
}

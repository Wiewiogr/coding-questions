package pl.tw.dailycodingquestion.num1to10;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * <p>
 * You can modify the input array in-place.
 */

public class CodingQuestion4 {

    public static void main(String[] args) {
        int[] array = new int[]{-1, 4, 2, 1, 9, 10};
//        int[] array = new int[]{1, 2, 0};
//        int[] array = new int[]{3, 4, -1, 1};

        int k = partition(array);
        System.out.println(Arrays.toString(array));
        mark(array, k);
        System.out.println(Arrays.toString(array));
        System.out.println(findMissing(array, k));
    }

    public static int findMissing(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            if (array[i] > 0) {
                return i + 1;
            }
        }
        return k + 1;
    }

    public static void mark(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            int positiveIndex = Math.abs(array[i]);
            if (positiveIndex <= k) {
                array[positiveIndex - 1] = -Math.abs(array[positiveIndex - 1]);
            }
        }
    }

    public static int partition(int[] array) {
        int cursor = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                swap(array, cursor, i);
                cursor++;
            }
        }
        return cursor;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

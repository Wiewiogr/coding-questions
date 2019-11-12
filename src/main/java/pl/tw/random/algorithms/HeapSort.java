package pl.tw.random.algorithms;

import java.util.Arrays;

import static pl.tw.random.algorithms.SortingUtils.createShuffledArray;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = createShuffledArray(100);

        System.out.println("before:");
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println("after:");
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        buildMaxHeap(array);

        int i = array.length;
        while (i > 0) {
            heapify(array, 0, i);
            swap(array, 0, i - 1);
            i--;
        }
    }

    private static void buildMaxHeap(int[] array) {
        int i = (array.length + 1) / 2;
        while (i >= 0) {
            heapify(array, i, array.length);
            i--;
        }
    }

    private static void heapify(int[] array, int i, int end) {
        int cur = i;
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;

        while ((left < end && array[left] > array[cur]) ||
                (right < end && array[right] > array[cur])) {

            if (right < end) {
                if (array[right] > array[left]) {
                    swap(array, right, cur);
                    cur = right;
                } else {
                    swap(array, left, cur);
                    cur = left;
                }
            } else {
                swap(array, left, cur);
                cur = left;
            }

            left = cur * 2 + 1;
            right = cur * 2 + 2;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

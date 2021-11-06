package pl.tw.random.algorithms;

import java.util.Arrays;

import static pl.tw.random.algorithms.SortingUtils.createShuffledArray;

public class HeapSort2 {

    public static void sort(int[] arr) {
        buildHeap(arr);

        int i = arr.length - 1;
        while (i > 0) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
            i--;
        }
    }

    private static void buildHeap(int[] arr) {
        int i = arr.length / 2 - 1;
        while (i >= 0) {
            heapify(arr, i, arr.length);
            i--;
        }
    }

    private static void heapify(int[] arr, int i, int end) {
        int cur = i;
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;

        while (left < end && arr[left] > arr[cur] ||
                right < end && arr[right] > arr[cur]) {

            if (right < end) {
                if (arr[left] > arr[right]) {
                    swap(arr, left, cur);
                    cur = left;
                } else {
                    swap(arr, right, cur);
                    cur = right;
                }
            } else {
                swap(arr, left, cur);
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


    public static void main(String[] args) {
        int[] array = createShuffledArray(100);

        System.out.println("before:");
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println("after:");
        System.out.println(Arrays.toString(array));
    }

}

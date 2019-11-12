package pl.tw.random.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeapSort {

    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(collect);

        int[] array = new int[100];
        for (int i = 0; i < collect.size(); i++) {
            array[i] = collect.get(i);
        }

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

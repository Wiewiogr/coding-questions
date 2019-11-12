package pl.tw.random.algorithms;

import java.util.Arrays;

import static pl.tw.dailycodingquestion.CodingQuestion4.swap;
import static pl.tw.random.algorithms.SortingUtils.createShuffledArray;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = createShuffledArray(100);
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }
}

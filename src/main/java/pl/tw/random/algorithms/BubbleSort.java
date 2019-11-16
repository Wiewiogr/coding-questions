package pl.tw.random.algorithms;

import java.util.Arrays;

import static pl.tw.dailycodingquestion.num1to10.CodingQuestion4.swap;
import static pl.tw.random.algorithms.SortingUtils.createShuffledArray;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = createShuffledArray(100);
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}

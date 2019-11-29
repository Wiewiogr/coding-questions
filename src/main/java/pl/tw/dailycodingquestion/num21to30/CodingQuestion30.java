package pl.tw.dailycodingquestion.num21to30;

/**
 * You are given an array of non-negative integers that represents a two-dimensional elevation map
 * where each element is unit-width wall and the integer is the height.
 * Suppose it will rain and all spots between two walls get filled up.
 * <p>
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 * <p>
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 * <p>
 * Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index,
 * 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left),
 * so we can trap 8 units of water.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class CodingQuestion30 {

    public static void main(String[] args) {
        System.out.println(countTrappedWater(new int[]{2, 1, 2}));
        System.out.println(countTrappedWater(new int[]{4, 3, 1, 3, 1, 5}));
        System.out.println(countTrappedWater(new int[]{1, 4, 3, 1, 5, 1}));
    }

    public static int countTrappedWater(int[] array) {
        if (array.length < 3) {
            return 0;
        }
        int maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[maxIndex] < array[i]) {
                maxIndex = i;
            }
        }

        int trappedWater = 0;

        int maxValueFromLeft = array[0];
        for (int i = 1; i < maxIndex; i++) {
            maxValueFromLeft = Math.max(maxValueFromLeft, array[i]);
            trappedWater += maxValueFromLeft - array[i];
        }

        if (maxIndex != array.length - 1) {
            int maxValueFromRight = array[array.length - 1];
            for (int i = array.length - 2; i > maxIndex; i--) {
                maxValueFromRight = Math.max(maxValueFromRight, array[i]);
                trappedWater += maxValueFromRight - array[i];
            }
        }

        return trappedWater;
    }
}

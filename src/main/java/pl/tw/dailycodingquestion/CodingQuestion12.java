package pl.tw.dailycodingquestion;

import java.util.List;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * <p>
 * What if, instead of being able to climb 1 or 2 steps at a time,
 * you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class CodingQuestion12 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4, List.of(1, 2)));
    }

    public static int climbStairs(int n, List<Integer> steps) {
        int[] result = new int[n + 1];
        result[0] = 1;

        for (int i = 1; i <= n; i++) {
            int newResult = 0;
            for (int step : steps) {
                if (i - step >= 0) {
                    newResult += result[i - step];
                }
            }
            result[i] = newResult;
        }
        return result[n];
    }
}

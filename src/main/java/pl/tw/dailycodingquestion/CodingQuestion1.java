package pl.tw.dailycodingquestion;

import java.util.HashSet;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 */

public class CodingQuestion1 {

    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 3, 7};
        System.out.println(checkIfAddsUp(array, 17));
    }

    public static boolean checkIfAddsUp(int[] array, int k) {
        HashSet<Integer> neededNumbers = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int needed = k - array[0];
            if (neededNumbers.contains(needed)) {
                return true;
            } else {
                neededNumbers.add(needed);
            }
        }
        return true;
    }
}

package pl.tw.leetCode;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> neededToId = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (neededToId.containsKey(nums[i])) {
                return new int[]{neededToId.get(nums[i]), i};
            }
            int needed = target - nums[i];
            neededToId.put(needed, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
    }
}

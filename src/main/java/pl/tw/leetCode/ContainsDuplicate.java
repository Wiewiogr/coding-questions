package pl.tw.leetCode;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seenNumbers.contains(nums[i])) {
                return true;
            } else {
                seenNumbers.add(nums[i]);
            }

        }
        return false;
    }
}

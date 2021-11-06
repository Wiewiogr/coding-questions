package pl.tw.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int neededSum = -nums[i];

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == neededSum) {
                    result.add(List.of(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;

                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
}

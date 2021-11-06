package pl.tw.leetCode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            if(curSum < 0) {
                curSum = 0;
            }

            curSum += num;

            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}

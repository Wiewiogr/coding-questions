package pl.tw.random.algorithms;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{0}, 0));
    }
}

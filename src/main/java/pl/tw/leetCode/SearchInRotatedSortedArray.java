package pl.tw.leetCode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = middle(l, r);
            System.out.println("l = " + l + ", m = " + m +", r = " + r );
            if (nums[m] == target) return m;
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target >= nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }


        }
        return -1;
    }

    private int middle(int l, int r) {
        return (l + r) / 2;
    }

    public static void main(String[] args) {
        System.out.println( new SearchInRotatedSortedArray().search(new int[]{3,1}, 1));
    }
}

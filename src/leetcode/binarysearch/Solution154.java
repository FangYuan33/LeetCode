package leetcode.binarysearch;

public class Solution154 {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 1, 3};
//        int[] nums = new int[]{1, 3, 5};
//        int[] nums = new int[]{2, 2, 2, 0, 1};
        int[] nums = new int[]{3, 3, 1, 3};
//        int[] nums = new int[]{3, 1, 1};

        System.out.println(new Solution154().findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            // 一定落在了大区间
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }
            // 一定落在了小区间
            if (nums[mid] < nums[right]) {
                right = mid;
                continue;
            }

            // 相等的情况可能在大区间也可能在小区间，不过现在的答案一定在 [left, right] 区间内，所以遍历找一下即可
            int min = nums[left];
            for (int i = left + 1; i <= right; i++) {
                min = Math.min(min, nums[i]);
            }

            return min;
        }

        return nums[left];
    }
}

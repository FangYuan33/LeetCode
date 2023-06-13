package leetcode.binarysearch;

public class Solution154 {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 1, 3};
//        int[] nums = new int[]{1, 3, 5};
//        int[] nums = new int[]{2, 2, 2, 0, 1};
        int[] nums = new int[]{3, 3, 1, 3};

        System.out.println(new Solution154().findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // 落在了小区间
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // 落在了大区间
                left = mid + 1;
            } else {
                // 相等情况，那么需要线性查找，而且存在左右两个区间都是相等的值的情况
                // 它可能在mid的左右两侧，答案一定在[left, right]之间
                int index = left;
                for (int i = left + 1; i < right; i++) {
                    if (nums[i] < nums[index]) {
                        index = i;
                    }
                }

                return nums[index];
            }
        }

        return nums[left];
    }
}

package leetcode;

public class Solution154 {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 1, 3};
//        int[] nums = new int[]{1, 3, 5};
//        int[] nums = new int[]{2, 2, 2, 0, 1};
        int[] nums = new int[]{3, 3, 1, 3};

        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return nums[right];
    }
}

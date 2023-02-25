package leetcode.binarysearch;

public class SolutionOffer53 {
    public int search(int[] nums, int target) {
        int res = 0;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                // 找到之后分别再向左向右找
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                res = right - left + 1;
                break;
            }
        }

        return res;
    }
}

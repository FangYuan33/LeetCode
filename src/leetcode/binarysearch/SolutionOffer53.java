package leetcode.binarysearch;

public class SolutionOffer53 {
    public int search(int[] nums, int target) {
        int res = 0;

        // 二分查找
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 找到了之后左找找右找找
                res++;
                // 注意这里索引值的定义
                int index = mid;
                while (index < nums.length - 1 && nums[index + 1] == target) {
                    res++;
                    index++;
                }
                index = mid;
                while (index > 0 && nums[index - 1] == target) {
                    res++;
                    index--;
                }
                break;
            }
        }


        return res;
    }
}

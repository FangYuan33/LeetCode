package leetcode.simulate;

public class Solution556 {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        int pos = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i - 1;
                break;
            }
        }
        // 从大到小严格递减则无更大的元素
        if (pos == -1) {
            return -1;
        }

        // 找到后面的比该位置大的最小元素
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[pos]) {
                swap(nums, i, pos);
                break;
            }
        }
        // 将 pos 后边严格递减的转换成严格递增
        int left = pos + 1, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        long res = Long.parseLong(String.valueOf(nums));

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    private void swap(char[] nums, int left, int right) {
        char temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

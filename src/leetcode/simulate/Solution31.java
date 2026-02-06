package simulate;

public class Solution31 {
    // eg: [1,3,5,4,2]
    public void nextPermutation(int[] nums) {
        int length = nums.length;

        // 先找到第一个当前数小于右边
        int i = length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }

        // 说明找到了
        if (i >= 0) {
            // 再去找大于当前值的最小值
            int min = Integer.MAX_VALUE;
            int j = i + 1;
            // k 表示实际要找的最终结果
            int k = j;
            while (j < length) {
                if (nums[j] > nums[i] && nums[j] < min) {
                    k = j;
                }
                j++;
            }
            swap(nums, i, k);
        }
        // 说明没找到，那么反转数组；找到了也把剩下的倒序的变成正序反转
        reverse(nums, i + 1, length -1 );
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}

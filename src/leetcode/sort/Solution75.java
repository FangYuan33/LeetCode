package leetcode.sort;

public class Solution75 {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int begin = 0;

        while (begin <= twoIndex) {
            // 除了2挪到合适的位置不需要begin++外
            // 剩下的不过是0和1之间的交换而已
            if (nums[begin] == 0) {
                swap(nums, begin, zeroIndex);
                zeroIndex++;
                begin++;
            } else if (nums[begin] == 2) {
                // 换到2的时候没有执行 begin++
                // 因为被换过来的这个值可能还需要被交换位置
                swap(nums, begin, twoIndex);
                twoIndex--;
            } else {
                begin++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

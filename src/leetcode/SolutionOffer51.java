package leetcode;

public class SolutionOffer51 {

    // 结果值
    private int count = 0;
    // temp数组用于保存有序的数组来更改原来无序的数组
    private int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 二分两个数组的起始节点
        int i = left, j = mid + 1;
        int t = left;

        while (i <= mid && j <= right) {
            // 左边数组比右边儿小直接存上
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                // 大的话直接计算逆序个数
                // 因为已经将原数组排序了，所以左边当前数大于右边儿数组的数的话
                // 那么当前数后边儿的数都大于右边儿的这个数，所以这么算
                count += mid - i + 1;
                temp[t++] = nums[j++];
            }
        }

        // 左右数组数量不等的时候，直接把没比较的放进数组里，后边儿的数是排序后比较大的
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }

        // 将原数组变成有序的，这样才能通过 mid - i + 1 来计算逆序对
        for (int k = left; k < t; k++) {
            nums[k] = temp[k];
        }
    }
}
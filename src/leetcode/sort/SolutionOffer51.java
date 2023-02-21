package leetcode.sort;

import java.util.Arrays;

public class SolutionOffer51 {

    public static void main(String[] args) {
//        System.out.println(new SolutionOffer51().reversePairs(new int[]{4,3,2,1}));
//        System.out.println(new SolutionOffer51().reversePairs(new int[]{4, 5, 6, 7}));
//        System.out.println(new SolutionOffer51().reversePairs(new int[]{7, 5, 6, 4}));
//        System.out.println(new SolutionOffer51().reversePairs(new int[]{233, 2000000001, 234, 2000000006, 235,
//                2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004}));
        System.out.println(new SolutionOffer51().reversePairs(new int[]{7, 10, 8, 12, 9, 7, 11}));
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        return res;
    }

    private int res = 0;

    /**
     * 归并排序处理问题
     */
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    /**
     * 合并，每出现一次左边儿比右边儿大那么就有一个逆序对
     */
    private void merge(int[] nums, int left, int mid, int right) {
        // 辅助数组
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);
        // 找出要对比的左右数组在辅助数组中的索引
        int leftBegin = 0, leftEnd = mid - left;
        int rightBegin = leftEnd + 1, rightEnd = right - left;

        // 注解下边 if 条件的比较条件中，需要把边界条件的比较放在前面！需要把边界条件的比较放在前面！需要把边界条件的比较放在前面！
        for (int i = left; i <= right; i++) {
            if (leftBegin > leftEnd) {
                // 左边数组多且未发生比较的情况
                nums[i] = temp[rightBegin++];
            } else if (rightBegin > rightEnd || temp[leftBegin] <= temp[rightBegin]) {
                // 左数组小或者右数组用完的情况
                nums[i] = temp[leftBegin++];
            } else {
                nums[i] = temp[rightBegin++];
                // 如果左数组当前数比右侧数大，那么左数组之后的数也比此时这个右侧的数大
                res += (leftEnd - leftBegin) + 1;
            }
        }
    }
}
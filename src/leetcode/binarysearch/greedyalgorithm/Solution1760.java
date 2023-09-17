package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution1760 {

    public static void main(String[] args) {
        System.out.println(new Solution1760().minimumSize(new int[]{9}, 2));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + right >> 1;

            int op = 0;
            for (int num : nums) {
                op += (num - 1) / mid;
            }
            if (op > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}

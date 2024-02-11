package leetcode.sort.algorithms;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};
        new InsertSort().sort(origin);
        System.out.println(Arrays.toString(origin));
    }

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = base;
        }
    }
}

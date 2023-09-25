package leetcode.sort.algorithms;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};
        new ShellSort().sort(origin);
        System.out.println(Arrays.toString(origin));
    }

    private void sort(int[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < nums.length; i++) {
                int base = nums[i];

                int j = i - h;
                while (j >= 0 && nums[j] > base) {
                    nums[j + h] = nums[j];
                    j -= h;
                }
                nums[j + h] = base;
            }
            h /= 3;
        }
    }
}

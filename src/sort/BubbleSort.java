package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 9, 2, 5, 8, 3};
        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >=0 ; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
}

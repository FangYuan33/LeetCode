package leetcode.sort;

import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        int[] nums = countingSort(costs);

        int res = 0;
        for (int num : nums) {
            if (coins >= num) {
                coins -= num;
                res++;
            } else {
                break;
            }
        }

        return res;
    }

    private int[] countingSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int[] counting = new int[max + 1];
        Arrays.stream(nums).forEach(x -> counting[x]++);
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = counting[nums[i]] - 1;
            res[index] = nums[i];
            counting[nums[i]]--;
        }

        return res;
    }
}

package leetcode.prefixsum;

import java.util.Arrays;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        // 左右方向各乘一次
        int[] answer1 = new int[nums.length];
        int[] answer2 = new int[nums.length];
        Arrays.fill(answer1, 1);
        Arrays.fill(answer2, 1);

        // 先乘后边
        for (int i = nums.length - 2; i >= 0; i--) {
            answer1[i] = answer1[i + 1] * nums[i + 1];
        }
        // 再乘左边
        for (int i = 1; i < nums.length; i++) {
            answer2[i] = answer2[i - 1] * nums[i - 1];
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer1[i] * answer2[i];
        }

        return answer;
    }
}

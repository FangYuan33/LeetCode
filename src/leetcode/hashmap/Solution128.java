package leetcode.hashmap;

import java.util.HashSet;

public class Solution128 {

    public static void main(String[] args) {
        System.out.println(new Solution128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // 先找到右边界
            if (!set.contains(num + 1)) {
                int length = 1;
                while (set.contains(num - 1)) {
                    length++;
                    num--;
                }
                res = Math.max(length, res);
            }
        }

        return res;
    }
}

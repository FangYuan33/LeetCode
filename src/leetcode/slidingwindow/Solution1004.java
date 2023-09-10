package leetcode.slidingwindow;

public class Solution1004 {

    public static void main(String[] args) {
        System.out.println(new Solution1004().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int[] mark = new int[nums.length];

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
                mark[right] = 1;
            }

            while (k < 0) {
                if (mark[left] == 1) {
                    k++;
                    mark[left]--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}

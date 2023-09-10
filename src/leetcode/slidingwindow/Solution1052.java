package leetcode.slidingwindow;

public class Solution1052 {

    public static void main(String[] args) {
        System.out.println(new Solution1052().maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
        }

        int max = 0;
        int sum = 0;
        int left = 0, right = 0;
        while (right < customers.length) {
            sum += customers[right];

            if (right - left + 1 > minutes) {
                sum -= customers[left];
                left++;
            }
            max = Math.max(max, sum);
            right++;
        }

        return res + max;
    }
}

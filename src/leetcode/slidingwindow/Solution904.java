package leetcode.slidingwindow;

public class Solution904 {

    public static void main(String[] args) {
        System.out.println(new Solution904().totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    public int totalFruit(int[] fruits) {
        int max = 2;
        int[] already = new int[fruits.length + 1];

        int res = 0;
        int left = 0, right = 0;
        while (right < fruits.length) {
            if (max > 0 || already[fruits[right]] > 0) {
                if (already[fruits[right]] == 0) {
                    max--;
                }
                already[fruits[right]]++;
                right++;

                res = Math.max(res, right - left);
            } else {
                already[fruits[left]]--;
                if (already[fruits[left]] == 0) {
                    max++;
                }
                left++;
            }
        }

        return res;
    }
}

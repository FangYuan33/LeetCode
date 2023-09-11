package leetcode.slidingwindow;

public class Solution904 {

    public static void main(String[] args) {
        System.out.println(new Solution904().totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    public int totalFruit(int[] fruits) {
        int res = 0;
        int k = 2;
        int[] mark = new int[fruits.length];

        int left = 0, right = 0;
        while (right < fruits.length) {
            if (mark[fruits[right]] == 0) {
                k--;
            }
            mark[fruits[right]]++;

            while (k < 0 && left < right) {
                mark[fruits[left]]--;
                if (mark[fruits[left]] == 0) {
                    k++;
                }
                left++;
            }
            res = Math.max(right - left + 1, res);
            right++;
        }

        return res;
    }
}

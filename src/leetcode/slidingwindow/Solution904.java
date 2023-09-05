package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution904 {

    public static void main(String[] args) {
        System.out.println(new Solution904().totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    public int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> bucket = new HashMap<>();

        int left = 0, right = 0;
        while (right < fruits.length) {
            bucket.put(fruits[right], bucket.getOrDefault(fruits[right], 0) + 1);

            while (bucket.size() > 2) {
                Integer remove = bucket.get(fruits[left]);
                if (remove - 1 == 0) {
                    bucket.remove(fruits[left]);
                } else {
                    bucket.put(fruits[left], remove - 1);
                }

                left++;
            }

            res = Math.max(right - left + 1, res);
            right++;
        }

        return res;
    }
}

package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution904 {

    public static void main(String[] args) {
        // 5
        System.out.println(new Solution904().totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> mark = new HashMap<>();
        int left = 0, right = 0;
        while (right < fruits.length) {
            mark.put(fruits[right], mark.getOrDefault(fruits[right], 0) + 1);

            while (mark.size() > 2 && left < right) {
                Integer num = mark.get(fruits[left]);
                if (num == 1) {
                    mark.remove(fruits[left]);
                } else {
                    mark.put(fruits[left], num - 1);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}

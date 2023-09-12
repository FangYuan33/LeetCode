package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution904 {

    public static void main(String[] args) {
        System.out.println(new Solution904().totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> fruitTypeNum = new HashMap<>();
        int left = 0, right = 0;
        while (right < fruits.length) {
            fruitTypeNum.put(fruits[right], fruitTypeNum.getOrDefault(fruits[right], 0) + 1);

            while (fruitTypeNum.size() > 2 && left < right) {
                Integer num = fruitTypeNum.get(fruits[left]);
                if (num == 1) {
                    fruitTypeNum.remove(fruits[left]);
                } else {
                    fruitTypeNum.put(fruits[left], --num);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}

package leetcode.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution954 {

    public static void main(String[] args) {
        System.out.println(new Solution954().canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> arrNum = new HashMap<>();
        for (int a : arr) {
            arrNum.put(a, arrNum.getOrDefault(a, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(arrNum.keySet());
        list.sort(Comparator.comparingInt(x -> x));
        for (Integer num : list) {
            if (num > 0) {
                Integer cur = arrNum.get(num);
                Integer two = arrNum.getOrDefault(num * 2, 0);
                if (two < cur) {
                    return false;
                }
                if (cur > 0) {
                    arrNum.put(num * 2, two - cur);
                }
            } else if (num < 0) {
                Integer cur = arrNum.get(num);
                Integer two = arrNum.getOrDefault(num / 2, 0);

                if (cur > 0 && (num % 2 != 0 || two < cur)) {
                    return false;
                }
                if (cur > 0) {
                    arrNum.put(num / 2, two - cur);
                }
            } else {
                if (arrNum.get(num) % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}

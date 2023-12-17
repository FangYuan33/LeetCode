package leetcode.hashmap;

import java.util.*;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        int n = nums.length / 3;
        LinkedList<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() > n) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}

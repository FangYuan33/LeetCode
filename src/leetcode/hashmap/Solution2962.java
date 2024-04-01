package leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int num = 0;

        // map 将对应的数量和索引记录下来
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        numIndex.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                num++;
                numIndex.put(num, i);
            }
            if (num >= k) {
                int maxIndex = numIndex.get(num - k + 1);
                res += (maxIndex + 1);
            }
        }

        return res;
    }
}

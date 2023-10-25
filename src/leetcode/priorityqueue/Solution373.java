package leetcode.priorityqueue;

import java.util.*;

public class Solution373 {
    boolean flag = true;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) {
            flag = false;
            return kSmallestPairs(nums2, nums1, k);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> (nums1[x[0]] + nums2[x[1]])));
        int min = Math.min(nums1.length, k);
        for (int i = 0; i < min; i++) {
            priorityQueue.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (res.size() < k && !priorityQueue.isEmpty()) {
            int[] pari = priorityQueue.poll();
            int f = pari[0], s = pari[1];

            if (flag) {
                res.add(Arrays.asList(nums1[f], nums2[s]));
            } else {
                res.add(Arrays.asList(nums2[s], nums1[f]));
            }
            if (s + 1 < nums2.length) {
                priorityQueue.offer(new int[]{f, s + 1});
            }
        }

        return res;
    }
}

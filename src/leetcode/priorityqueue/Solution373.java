package leetcode.priorityqueue;

import java.util.*;

public class Solution373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // nums1Index, nums2Index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> (nums1[x[0]] + nums2[x[1]])));
        for (int i = 0; i < nums1.length; i++) {
            priorityQueue.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (res.size() < k && !priorityQueue.isEmpty()) {
            int[] element = priorityQueue.poll();
            res.add(Arrays.asList(nums1[element[0]], nums2[element[1]]));

            if (element[1] + 1 < nums2.length) {
                priorityQueue.offer(new int[]{element[0], element[1] + 1});
            }
        }

        return res;
    }
}

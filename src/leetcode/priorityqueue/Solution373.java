package leetcode.priorityqueue;

import java.util.*;

public class Solution373 {

    public static void main(String[] args) {
        System.out.println(new Solution373().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> (nums1[x[0]] + nums2[x[1]])));
        for (int i = 0; i < nums1.length; i++) {
            priorityQueue.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            int[] e = priorityQueue.poll();
            res.add(Arrays.asList(nums1[e[0]], nums2[e[1]]));
            if (e[1] + 1 < nums2.length) {
                priorityQueue.offer(new int[]{e[0], e[1] + 1});
            }
        }

        return res;
    }
}

package leetcode.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution373 {

    static class Pair implements Comparable<Pair> {

        List<Integer> nums;

        int sum;

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pairs = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                Pair pair = new Pair();
                pair.nums = new ArrayList<>(Arrays.asList(nums1[i], nums1[j]));
                pair.sum = nums1[i] + nums2[j];

                pairs.add(pair);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!pairs.isEmpty() && res.size() < k) {
            res.add(pairs.remove().nums);
        }

        return res;
    }
}

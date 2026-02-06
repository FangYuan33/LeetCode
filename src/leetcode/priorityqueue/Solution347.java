package priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {

    public static void main(String[] args) {
        new Solution347().topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums;
        }

        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> numCountEntry : numCountMap.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new Element(numCountEntry.getKey(), numCountEntry.getValue()));
            } else {
                if (numCountEntry.getValue() > priorityQueue.peek().count) {
                    priorityQueue.poll();
                    priorityQueue.offer(new Element(numCountEntry.getKey(), numCountEntry.getValue()));
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.poll().value;
        }

        return res;
    }

    private static class Element implements Comparable<Element> {
        int value;
        int count;

        public Element(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Element o) {
            return this.count - o.count;
        }
    }

}

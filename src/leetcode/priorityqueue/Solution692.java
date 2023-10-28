package leetcode.priorityqueue;

import java.util.*;

public class Solution692 {

    public static void main(String[] args) {
        System.out.println(new Solution692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    static class WordNum implements Comparable<WordNum> {

        String word;

        int num;

        public WordNum(String word) {
            this.word = word;
            this.num = 1;
        }

        @Override
        public int compareTo(WordNum o) {
            if (this.num != o.num) {
                return this.num - o.num;
            } else {
                return o.word.compareTo(this.word);
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, WordNum> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.get(word).num++;
            } else {
                map.put(word, new WordNum(word));
            }
        }

        PriorityQueue<WordNum> priorityQueue = new PriorityQueue<>();
        for (WordNum value : map.values()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(value);
            } else {
                if (value.compareTo(priorityQueue.peek()) > 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(value);
                }
            }
        }

        LinkedList<String> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.addFirst(priorityQueue.poll().word);
        }

        return res;
    }
}

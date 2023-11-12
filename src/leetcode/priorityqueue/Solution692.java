package leetcode.priorityqueue;

import java.util.*;

public class Solution692 {

    public static void main(String[] args) {
        System.out.println(new Solution692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    static class WordNum implements Comparable<WordNum> {

        String word;

        int num;

        public WordNum(String word, int num) {
            this.word = word;
            this.num = num;
        }

        @Override
        public int compareTo(WordNum o) {
            if (this.num == o.num) {
                return this.word.compareTo(o.word);
            } else {
                return o.num - this.num;
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordNum = new HashMap<>();
        for (String word : words) {
            wordNum.put(word, wordNum.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<WordNum> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : wordNum.entrySet()) {
            priorityQueue.offer(new WordNum(entry.getKey(), entry.getValue()));
        }

        List<String> res = new LinkedList<>();
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            res.add(priorityQueue.poll().word);
        }

        return res;
    }
}

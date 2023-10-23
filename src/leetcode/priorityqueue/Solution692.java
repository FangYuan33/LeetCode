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
        HashMap<String, WordNum> wordObject = new HashMap<>();
        for (String word : words) {
            if (wordObject.containsKey(word)) {
                WordNum wordNum = wordObject.get(word);
                wordNum.num++;
            } else {
                wordObject.put(word, new WordNum(word));
            }
        }

        PriorityQueue<WordNum> priorityQueue = new PriorityQueue<>();
        for (WordNum value : wordObject.values()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(value);
            } else {
                if (value.num >= priorityQueue.peek().num) {
                    priorityQueue.offer(value);
                    priorityQueue.poll();
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

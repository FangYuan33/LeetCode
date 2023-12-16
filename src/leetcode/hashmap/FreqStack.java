package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreqStack {

    HashMap<Integer, Integer> numFreq;

    HashMap<Integer, List<Integer>> freqNum;

    int maxFreq;

    public FreqStack() {
        numFreq = new HashMap<>();
        freqNum = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = numFreq.getOrDefault(val, 0) + 1;
        numFreq.put(val, freq);

        maxFreq = Math.max(maxFreq, freq);

        List<Integer> list = freqNum.getOrDefault(freq, new ArrayList<>());
        list.add(val);
        freqNum.put(freq, list);
    }

    public int pop() {
        List<Integer> list = freqNum.get(maxFreq);
        Integer res = list.remove(list.size() - 1);
        numFreq.put(res, maxFreq - 1);
        if (list.size() == 0) {
            maxFreq--;
        }
        return res;
    }
}

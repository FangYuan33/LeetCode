package leetcode.str;

import java.util.*;

public class Solution187 {

    public static void main(String[] args) {
        new Solution187().findRepeatedDnaSequences("AAAAAAAAAAA");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String dna = s.substring(i, i + 10);
            map.put(dna, map.getOrDefault(dna, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}

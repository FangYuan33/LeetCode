package leetcode.hashmap;

import java.util.HashMap;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> mapS = getCharNumMap(s);
        HashMap<Character, Integer> mapT = getCharNumMap(t);

        for (char c : t.toCharArray()) {
            if (!mapS.containsKey(c) || !mapS.get(c).equals(mapT.get(c))) {
                return false;
            }
        }

        return true;
    }

    private HashMap<Character, Integer> getCharNumMap(String s) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        return mapS;
    }
}

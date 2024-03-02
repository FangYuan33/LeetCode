package leetcode.hashmap;

import java.util.HashMap;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapping1 = new HashMap<>();
        HashMap<Character, Character> mapping2 = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            if (mapping1.containsKey(sCharArray[i])) {
                if (mapping1.get(sCharArray[i]) != tCharArray[i]) {
                    return false;
                }
            } else if (mapping2.containsKey(tCharArray[i])) {
                if (mapping2.get(tCharArray[i]) != sCharArray[i]) {
                    return false;
                }
            } else {
                mapping1.put(sCharArray[i], tCharArray[i]);
                mapping2.put(tCharArray[i], sCharArray[i]);
            }
        }

        return true;
    }
}

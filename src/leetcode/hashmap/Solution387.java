package leetcode.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution387 {

    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (linkedHashMap.containsKey(charArray[i])) {
                linkedHashMap.put(charArray[i], -1);
            } else {
                linkedHashMap.put(charArray[i], i);
            }
        }

        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }

        return -1;
    }
}

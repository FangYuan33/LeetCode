package leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Interview1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> element = hashMap.getOrDefault(key, new ArrayList<>());
            element.add(str);
            hashMap.put(key, element);
        }

        return new ArrayList<>(hashMap.values());
    }
}

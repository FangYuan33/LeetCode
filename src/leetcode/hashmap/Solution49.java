package leetcode.hashmap;

import java.util.*;

public class Solution49 {

    public static void main(String[] args) {
        System.out.println(new Solution49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class Key {

        String string;

        int[] all;

        public Key(String string) {
            all = new int[26];
            this.string = string;
            char[] charArray = string.toCharArray();
            // 统计所有的数量
            for (char c : charArray) {
                all[c - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            // hash到一个位置之后，判断是否是同一个 key
            Key str = (Key) o;
            if (this.string.equals(str.string)) {
                return true;
            }

            int[] other = str.all;
            for (int i = 0; i < all.length; i++) {
                if (all[i] != other[i]) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public int hashCode() {
            // 保证它们 hash 到一个位置
            return Arrays.hashCode(all);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Key, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Key key = new Key(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                LinkedList<String> element = new LinkedList<>();
                element.add(str);
                map.put(key, element);
            }
        }

        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<Key, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}

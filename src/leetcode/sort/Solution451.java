package leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution451 {

    static class CharNum implements Comparable<CharNum> {

        char c;

        int num;

        public CharNum(char c) {
            this.c = c;
            this.num = 1;
        }

        @Override
        public int compareTo(CharNum o) {
            return o.num - this.num;
        }
    }

    public String frequencySort(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, CharNum> charObject = new HashMap<>();
        ArrayList<CharNum> list = new ArrayList<>();

        for (char c : charArray) {
            if (charObject.containsKey(c)) {
                CharNum charNum = charObject.get(c);
                charNum.num++;
            } else {
                CharNum charNum = new CharNum(c);
                charObject.put(c, charNum);
                list.add(charNum);
            }
        }
        Collections.sort(list);

        StringBuilder res = new StringBuilder();
        for (CharNum charNum : list) {
            while (charNum.num != 0) {
                charNum.num--;
                res.append(charNum.c);
            }
        }

        return res.toString();
    }
}

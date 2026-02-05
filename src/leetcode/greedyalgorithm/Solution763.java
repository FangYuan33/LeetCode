package greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public static void main(String[] args) {
        System.out.println(new Solution763().partitionLabels("caedbdedda"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        char[] charArray = s.toCharArray();
        // 记录每个字母的最大 index
        int[] lastIndex = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i] - 'a'] = Math.max(lastIndex[charArray[i] - 'a'], i);
        }

        int start = 0, end = 0;
        for (int i = 0; i < charArray.length; i++) {
            end = Math.max(end, lastIndex[charArray[i] - 'a']);
            // 说明找到了第一段
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

}

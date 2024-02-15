package leetcode.dp.backtrack;

import java.util.HashSet;
import java.util.Set;

public class SolutionLCR157 {

    private Set<String> res;

    public String[] goodsOrder(String goods) {
        char[] charArray = goods.toCharArray();
        res = new HashSet<>();
        backtrack(charArray, new boolean[goods.length()], new StringBuilder());

        return res.toArray(new String[0]);
    }

    private void backtrack(char[] charArray, boolean[] visited, StringBuilder element) {
        if (element.length() == charArray.length) {
            res.add(element.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            element.append(charArray[i]);
            backtrack(charArray, visited, element);
            visited[i] = false;
            element.deleteCharAt(element.length() - 1);
        }
    }
}

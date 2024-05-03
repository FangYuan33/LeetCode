package leetcode.dp.backtrack;

import java.util.Arrays;
import java.util.LinkedList;

public class SolutionLCR157 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionLCR157().goodsOrder("aab")));
    }

    LinkedList<String> res;

    public String[] goodsOrder(String goods) {
        res = new LinkedList<>();
        char[] charArray = goods.toCharArray();
        Arrays.sort(charArray);
        backtrack(charArray, new boolean[charArray.length], new StringBuilder());
        return res.toArray(new String[0]);
    }

    private void backtrack(char[] charArray, boolean[] visited, StringBuilder path) {
        if (path.length() == charArray.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (visited[i] || (i > 0 && charArray[i - 1] == charArray[i] && !visited[i - 1])) {
                continue;
            }
            path.append(charArray[i]);
            visited[i] = true;
            backtrack(charArray, visited, path);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}

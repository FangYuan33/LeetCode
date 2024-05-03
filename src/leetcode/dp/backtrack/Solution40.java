package leetcode.dp.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        System.out.println(new Solution40().combinationSum2(candidates, 5));
    }

    List<List<Integer>> res;

    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        this.target = target;
        Arrays.sort(candidates);

        backtrack(candidates, new boolean[candidates.length], 0, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, boolean[] visited, int index, LinkedList<Integer> path, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add((List<Integer>) path.clone());
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && candidates[i - 1] == candidates[i])) {
                continue;
            }

            path.add(candidates[i]);
            visited[i] = true;
            backtrack(candidates, visited, i + 1, path, sum + candidates[i]);
            path.removeLast();
            visited[i] = false;
        }
    }
}

package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> res;
    int beginIndex = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(new LinkedList<>(), 0, candidates, target);

        return res;
    }

    private void backtrack(LinkedList<Integer> element, int sum, int[] candidates, int target) {
        // 结束条件
        if (sum >= target) {
            if (sum == target) {
                res.add((List) element.clone());
            }

            return;
        }

        for (int i = beginIndex; i < candidates.length; i++) {
            element.add(candidates[i]);
            sum += candidates[i];
            // 难点就在这里而已，其实也不难
            beginIndex = i;

            backtrack(element, sum, candidates, target);

            sum -= candidates[i];
            element.removeLast();
        }
    }
}

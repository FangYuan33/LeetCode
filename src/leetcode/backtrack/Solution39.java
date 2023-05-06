package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, new LinkedList<Integer>(), 0, target);

        return res;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> element, int begin, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add((List) element.clone());
            }

            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            target -= candidates[i];
            element.add(candidates[i]);

            // 注意这里的 i 的选择
            backtrack(candidates, element, i, target);

            // 回溯完成后移除
            target += candidates[i];
            element.removeLast();
        }
    }
}

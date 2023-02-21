package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(target, new LinkedList<>(), candidates, 0);
        return res;
    }

    private void backtrack(int target, LinkedList<Integer> element, int[] candidates, int index) {
        // 结束条件 target为0
        if (target == 0) {
            res.add((List) element.clone());
        }

        for (int i = index; i < candidates.length; i++) {
            // 如果当前数比目标值小的话才继续向下回溯
            if (candidates[i] <= target) {
                // 去重
                if (i > index && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                target -= candidates[i];
                element.addLast(candidates[i]);
                backtrack(target, element, candidates, i + 1);
                // 执行完该轮 把添加和改动的值去掉
                target += candidates[i];
                element.removeLast();
            }
        }
    }
}

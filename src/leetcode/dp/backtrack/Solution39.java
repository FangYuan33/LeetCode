package leetcode.dp.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution39 {

    List<List<Integer>> res;

    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        this.target = target;
        backtrack(candidates, 0, new LinkedList<>(), 0);
        return res;
    }

    /**
     * 1. 当前问题：向路径中添加第 i 个元素
     * 2. 每一步的操作：直接添加元素
     * 3. 子问题：向路径中添加第 i + 1 个元素
     * 4. 剪枝优化：sum > target
     */
    private void backtrack(int[] candidates, int index, LinkedList<Integer> path, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add((List<Integer>) path.clone());
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i, path, sum);
            // 恢复现场
            path.removeLast();
            sum -= candidates[i];
        }
    }
}

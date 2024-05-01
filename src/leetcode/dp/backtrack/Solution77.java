package leetcode.dp.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution77 {

    List<List<Integer>> res;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        this.k = k;
        backtrack(n, 0, new LinkedList<>());
        return res;
    }

    // 当前问题：在路径中加入第 i 个元素
    // 每一步的操作：加入当前元素或不加入当前元素
    // 子问题：在路径中加入第 i + 1 个元素
    // 剪枝优化（边界条件）：剩余的元素全加上也不足够构造出k的组合；达到k个元素时
    private void backtrack(int n, int step, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add((List<Integer>) path.clone());
            return;
        }
        // 剪枝优化
        if (n - step + path.size() < k) {
            return;
        }


        // 加
        path.add(n - step);
        backtrack(n, step + 1, path);
        // 加入过元素后需要恢复现场
        path.removeLast();
        // 不加
        backtrack(n, step + 1, path);
    }

}

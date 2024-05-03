package leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution77 {

    List<List<Integer>> res;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        this.k = k;
        backtrack(n, new LinkedList<>());
        return res;
    }

    // 1. 当前问题：在路径中添加第 i 个元素
    // 2. 每一步的操作：加入当前元素或不加入当前元素
    // 3. 子问题：在路径中添加第 i + 1 个元素
    // 4. 剪枝优化：路径中的元素为 k 个时；路径中的元素加上可选择列表中的剩余的元素不足 k 个时；n 取值小于等于 0 时
    private void backtrack(int n, LinkedList<Integer> path) {
        // 剪枝优化
        if (path.size() == k) {
            res.add((List<Integer>) path.clone());
            return;
        }
        if (n + path.size() < k) {
            return;
        }
        if (n <= 0) {
            return;
        }

        // 加
        path.add(n);
        backtrack(n - 1,  path);
        // 加入过元素后需要恢复现场
        path.removeLast();
        // 不加
        backtrack(n - 1, path);
    }

}

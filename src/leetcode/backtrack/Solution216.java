package leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution216 {

    List<List<Integer>> res;

    int n;

    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new LinkedList<>();
        this.k = k;
        this.n = n;
        backtrack(9, new LinkedList<>(), 0);
        return res;
    }

    // 1. 当前问题：在路径中添加第 i 个元素
    // 2. 在每一步中的操作：添加该值或不添加该值
    // 3. 子问题：在路径中添加第 i + 1 个元素
    // 4. 剪枝优化：元素大于等于 k 个；元素和大于等于 n；num 取值小于等于 0
    private void backtrack(int num, LinkedList<Integer> path, int sum) {
        if (path.size() == k && sum == n) {
            res.add((List<Integer>) path.clone());
            return;
        }
        if (path.size() >= k) {
            return;
        }
        if (sum > n) {
            return;
        }
        if (num <= 0) {
            return;
        }

        // 添加
        path.add(num);
        backtrack(num - 1, path, sum + num);
        path.removeLast();
        // 不添加
        backtrack(num - 1, path, sum);
    }

}

package leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution78 {

    // 定义全局变量
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    /**
     * 回溯
     *
     * @param nums 选择列表
     * @param begin 构造子集开始的子数组索引
     * @param path 走过的路径
     */
    private void backtrack(int[] nums, int begin, LinkedList<Integer> path) {
        // 走过的所有路径均为答案之一
        res.add((List<Integer>) path.clone());
        for (int i = begin; i < nums.length; i++) {
            // 每一步的操作：将下边大于等于 begin 的元素加入到路径中
            path.add(nums[i]);
            // 子问题：
            backtrack(nums, i + 1, path);
            // 恢复现场：即将递归前加入路径的元素移除
            path.removeLast();
        }
    }
}

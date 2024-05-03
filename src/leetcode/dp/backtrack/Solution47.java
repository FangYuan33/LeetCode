package leetcode.dp.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {

    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        // 存在重复元素，则需要进行排序
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new LinkedList<>());
        return res;
    }

    // 1. 当前问题：向路径中添加第 i 个元素
    // 2. 每一步的操作：根据元素的添加情况添加元素：如果与当前元素值相等的元素已经被撤销选择，那么则不能再进行添加了
    // 3. 子问题：向路径中添加第 i + 1 个元素
    private void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> path) {
        // 结束条件
        if (nums.length == path.size()) {
            res.add((List<Integer>) path.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, path);
            // 恢复现场
            path.removeLast();
            visited[i] = false;
        }
    }
}

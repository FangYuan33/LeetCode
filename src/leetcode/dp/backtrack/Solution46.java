package leetcode.dp.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution46().permute(nums));
    }

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        backtrack(nums, new boolean[nums.length], new LinkedList<>());
        return res;
    }

    // 1. 当前问题：向路径中添加第 i 个元素
    // 2. 每一步的操作：根据元素的添加情况选择添加元素
    // 3. 子问题：向路径中添加第 i + 1 个元素
    private void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> path) {
        // 结束条件
        if (path.size() == nums.length) {
            res.add((List<Integer>) path.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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

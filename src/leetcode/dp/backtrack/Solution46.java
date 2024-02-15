package leetcode.dp.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> element) {
        // 某排列和数组长度一致时结束
        if (element.size() == nums.length) {
            res.add((List) element.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            element.addLast(nums[i]);
            // 回溯
            backtrack(nums, visited, element);
            // 移除添加的结果
            element.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution46().permute(nums));
    }
}

package leetcode.dp.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Solution78 {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int begin, LinkedList<Integer> element) {
        res.add((List<Integer>) element.clone());

        for (int i = begin; i < nums.length; i++) {
            element.add(nums[i]);
            backtrack(nums, i + 1, element);
            element.removeLast();
        }
    }
}

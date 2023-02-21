package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        res.add(new ArrayList<>());
        backtrack(new LinkedList<>(), nums, 0);

        return res;
    }

    private void backtrack(LinkedList<Integer> element, int[] nums, int begin) {
        // 结束条件
        if (begin == nums.length) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            element.addLast(nums[i]);
            res.add((List) element.clone());

            backtrack(element, nums, i + 1);

            element.removeLast();
        }
    }
}

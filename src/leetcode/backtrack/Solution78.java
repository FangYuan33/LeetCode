package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());

        backtrack(nums, new LinkedList<>(), 0);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> element, int beginIndex) {
        // 结束条件
        if (beginIndex == nums.length) {
            return;
        }

        for (int i = beginIndex; i < nums.length; i++) {
            element.addLast(nums[i]);
            res.add((List) element.clone());

            backtrack(nums, element, i + 1);

            element.removeLast();
        }
    }
}

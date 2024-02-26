package leetcode.dp.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {

    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        // 排序是为了后面的剪枝
        Arrays.sort(nums);
        backtrack(nums, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> element, boolean[] used) {
        if (element.size() == nums.length) {
            res.add(new ArrayList<>(element));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素已经被使用过，或者当前元素和前一个元素相同，且前一个元素刚被选择过
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            element.add(nums[i]);
            used[i] = true;
            backtrack(nums, element, used);
            element.removeLast();
            used[i] = false;
        }
    }
}

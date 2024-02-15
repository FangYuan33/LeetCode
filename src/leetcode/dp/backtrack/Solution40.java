package leetcode.dp.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 5, 2, 1, 2};

        System.out.println(new Solution40().combinationSum2(candidates, 5));
    }

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        // *排序
        Arrays.sort(candidates);
        backtrack(candidates, 0, new LinkedList<>(), target);

        return res;
    }

    private void backtrack(int[] candidates, int begin, LinkedList<Integer> element, int target) {
        // 结束条件
        if (target <= 0) {
            if (target == 0) {
                res.add((List) element.clone());
            }
            return;
        }

        // 做选择
        for (int i = begin; i < candidates.length; i++) {
            // 去重，正常情况下 i > begin 是第一次选不进这里
            // 只有说经过第一轮选择之后，再次进入这个循环才会来这里做校验，校验的是上一轮结果中是否在这个位置选过改元素，如果选过的话，需要跳过去重
            if (i > begin && candidates[i - 1] == candidates[i]) {
                continue;
            }

            target -= candidates[i];
            element.add(candidates[i]);

            backtrack(candidates, i + 1, element, target);

            target += candidates[i];
            element.removeLast();
        }
    }
}

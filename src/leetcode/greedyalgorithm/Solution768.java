package leetcode.greedyalgorithm;

import java.util.ArrayDeque;

public class Solution768 {
    public int maxChunksToSorted(int[] arr) {
        // 保留块中最大值作为块的代表
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int num : arr) {
            // 如果存在比当前最大值块小的元素，那么该元素需要将其余较大的元素挤走，因为这些待被挤走的元素已经不能够成为块的代表了
            if(!stack.isEmpty() && num < stack.getLast()) {
                int max = stack.removeLast();
                while(!stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                // 最终入栈的是最大值而不是 num 因为 num 会作为该最大值块中的一个元素
                stack.addLast(max);
            } else {
                // 比最大值 >= 的直接入栈
                stack.addLast(num);
            }
        }
        return stack.size();
    }
}

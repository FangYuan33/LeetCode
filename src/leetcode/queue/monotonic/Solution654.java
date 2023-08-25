package leetcode.queue.monotonic;

import leetcode.TreeNode;

import java.util.ArrayDeque;

public class Solution654 {
    public static void main(String[] args) {
        new Solution654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        // 单调递减队列存最大值
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = left; i <= right; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        // 当前区间最大值的索引
        Integer index = deque.pollFirst();
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = build(left, index - 1);
        treeNode.right = build(index + 1, right);

        return treeNode;
    }

}

package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution129 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        new Solution129().sumNumbers(node);
    }

    List<LinkedList<Integer>> all;

    public int sumNumbers(TreeNode root) {
        all = new ArrayList<>();
        doSumNumbers(root, new LinkedList<>());

        int res = 0;
        for (LinkedList<Integer> list : all) {
            StringBuilder builder = new StringBuilder();
            for (Integer i : list) {
                builder.append(i);
            }
            res += Integer.parseInt(builder.toString());
        }

        return res;
    }

    private void doSumNumbers(TreeNode node, LinkedList<Integer> element) {
        if (node == null) {
            return;
        }

        element.addLast(node.val);
        if (node.left == null && node.right == null) {
            all.add((LinkedList<Integer>) element.clone());
        }
        doSumNumbers(node.left, element);
        doSumNumbers(node.right, element);

        element.removeLast();
    }
}

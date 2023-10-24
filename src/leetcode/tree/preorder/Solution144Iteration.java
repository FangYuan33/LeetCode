package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144Iteration {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }

}

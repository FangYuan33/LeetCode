package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum, new LinkedList<>());
        return res;
    }

    private void preOrder(TreeNode root, int targetSum, LinkedList<Integer> element) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        element.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add((List<Integer>) element.clone());
            }
        }

        preOrder(root.left, targetSum, element);
        preOrder(root.right, targetSum, element);

        element.removeLast();
    }
}

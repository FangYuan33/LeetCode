package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrder(root, new LinkedList<>(), targetSum);
        return res;
    }

    private void preOrder(TreeNode node, LinkedList<Integer> element, int sum) {
        if (node == null) {
            return;
        }

        sum -= node.val;
        element.addLast(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            res.add((List<Integer>) element.clone());
        }
        preOrder(node.left, element, sum);
        preOrder(node.right, element, sum);

        element.removeLast();
    }
}

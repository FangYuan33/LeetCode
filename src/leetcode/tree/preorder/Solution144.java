package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {

    List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        preorder(root);

        return res;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}

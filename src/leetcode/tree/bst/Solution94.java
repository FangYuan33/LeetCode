package leetcode.tree.bst;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {

    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        midOrder(root);
        return res;
    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);
        res.add(root.val);
        midOrder(root.right);
    }
}

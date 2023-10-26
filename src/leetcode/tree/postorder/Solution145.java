package leetcode.tree.postorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {

    List<Integer> res;

    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        postOrder(root);
        return res;
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        res.add(node.val);
    }
}

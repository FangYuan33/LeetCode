package leetcode.tree.midorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionLCR174 {

    List<Integer> res;

    public int findTargetNode(TreeNode root, int cnt) {
        res = new ArrayList<>();
        midOrder(root);
        return res.get(res.size() - cnt);
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

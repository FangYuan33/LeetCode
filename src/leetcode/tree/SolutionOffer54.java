package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionOffer54 {
    List<Integer> list;

    public int kthLargest(TreeNode root, int k) {
        list = new ArrayList<>();
        midOrder(root);

        return list.get(list.size() - k);
    }

    private void midOrder(TreeNode root) {
        // 结束条件
        if (root == null) {
            return;
        }

        midOrder(root.left);
        list.add(root.val);
        midOrder(root.right);
    }
}

package leetcode.tree.bst;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionLCR174 {

    List<Integer> nodes;

    public int findTargetNode(TreeNode root, int cnt) {
        nodes = new ArrayList<>();
        midOrder(root);
        return nodes.get(nodes.size() - cnt);
    }

    private void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        nodes.add(node.val);
        midOrder(node.right);
    }
}

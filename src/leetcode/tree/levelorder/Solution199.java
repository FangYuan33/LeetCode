package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            res.add(linkedList.getLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
        }

        return res;
    }
}

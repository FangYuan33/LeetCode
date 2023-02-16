package tree;

import leetcode.TreeNode;

public class Traverse {

    public void traverse(TreeNode root) {
        // 前序遍历
        traverse(root);
        // 中序遍历
        traverse(root);
        // 后续遍历
        traverse(root);
    }
}

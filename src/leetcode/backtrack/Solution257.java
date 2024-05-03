package leetcode.backtrack;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution257 {

    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new LinkedList<>();
        backtrack(root, new StringBuilder());
        return res;
    }

    // 当前问题：从当前节点构造路径
    // 每一步的操作：将当前节点加入到路径中
    // 子问题：从左节点和右节点中构造路径（根左右的前序遍历）
    private void backtrack(TreeNode node, StringBuilder path) {
        // 到达叶子节点
        if (node.left == null && node.right == null) {
            res.add(path.append(node.val).toString());
            return;
        }

        // 每一步的操作，将当前节点加入到路径中
        path.append(node.val).append("->");
        int index = path.length();
        if (node.left != null) {
            // 子问题
            backtrack(node.left, path);
            // 恢复现场
            path = new StringBuilder(path.substring(0, index));
        }
        if (node.right != null) {
            backtrack(node.right, path);
        }
    }
}

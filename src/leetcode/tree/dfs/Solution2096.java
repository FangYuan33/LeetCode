package leetcode.tree.dfs;

import leetcode.TreeNode;

public class Solution2096 {

    public static void main(String[] args) {
        // 5, 1,2,3,6,4
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(4);

        System.out.println(new Solution2096().getDirections(treeNode, 3, 6));
    }

    String startPath, destPath;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, destValue, new StringBuilder());
        int commonLength = 0;
        int min = Math.min(startPath.length(), destPath.length());
        for (int i = 0; i < min && startPath.charAt(i) == destPath.charAt(i); i++) {
            commonLength++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = startPath.length() - 1; i >= commonLength; i--) {
            res.append("U");
        }
        for (int i = commonLength; i < destPath.length(); i++) {
            res.append(destPath.charAt(i));
        }
        return res.toString();
    }

    private void dfs(TreeNode root, int startValue, int destValue, StringBuilder path) {
        if (root == null) {
            return;
        }
        if (root.val == startValue) {
            startPath = path.toString();
        }
        if (root.val == destValue) {
            destPath = path.toString();
        }

        if (startPath != null && destPath != null) {
            return;
        }
        path.append("L");
        dfs(root.left, startValue, destValue, path);
        path.setLength(path.length() - 1);
        path.append("R");
        dfs(root.right, startValue, destValue, path);
        path.setLength(path.length() - 1);
    }
}

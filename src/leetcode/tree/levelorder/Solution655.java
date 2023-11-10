package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution655 {

    public static void main(String[] args) {
        System.out.println(new Solution655().printTree(new Codec().deserialize("1,2")));
    }

    static class TreeNodeIndex {

        TreeNode node;

        int m;

        int n;

        public TreeNodeIndex(TreeNode node, int m, int n) {
            this.node = node;
            this.m = m;
            this.n = n;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new LinkedList<>();
        int height = depth(root) - 1;
        int n = (int) (Math.pow(2, height + 1) - 1);

        ArrayList<String> element = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            element.add("");
        }

        LinkedList<TreeNodeIndex> queue = new LinkedList<>();
        queue.offer(new TreeNodeIndex(root, 0, (n - 1) / 2));
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<String> e = (ArrayList<String>) element.clone();
            for (int i = 0; i < size; i++) {
                TreeNodeIndex node = queue.poll();
                e.set(node.n, String.valueOf(node.node.val));

                int commonValue = (int) Math.pow(2, height - node.m - 1);
                if (node.node.left != null) {
                    queue.offer(new TreeNodeIndex(node.node.left, node.m + 1, node.n - commonValue));
                }
                if (node.node.right != null) {
                    queue.offer(new TreeNodeIndex(node.node.right, node.m + 1, node.n + commonValue));
                }
            }
            res.add(e);
        }

        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.max(left, right) + 1;
    }
}

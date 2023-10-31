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
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int height = height(root);
        int m = height;
        int n = (int) (Math.pow(2, height) - 1);
        for (int i = 0; i < m; i++) {
            ArrayList<String> element = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                element.add("");
            }
            res.add(element);
        }

        Queue<TreeNodeIndex> queue = new LinkedList<>();
        queue.offer(new TreeNodeIndex(root, 0, (n - 1) / 2));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeIndex node = queue.poll();
                int r = node.m, c = node.n;
                res.get(r).set(c, String.valueOf(node.node.val));

                int newM = r + 1;
                int common = (int) Math.pow(2, height - 2 - r);
                if (node.node.left != null) {
                    int newN = c - common;
                    queue.offer(new TreeNodeIndex(node.node.left, newM, newN));
                }
                if (node.node.right != null) {
                    int newN = c + common;
                    queue.offer(new TreeNodeIndex(node.node.right, newM, newN));
                }
            }
        }

        return res;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}

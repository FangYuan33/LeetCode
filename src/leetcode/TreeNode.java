package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void print() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size != 0) {
                size--;
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer((node.right));
                    System.out.print(node.val);
                } else {
                    System.out.print("null");
                }
                if (size != 0) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}

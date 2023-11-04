package leetcode.tree.bst;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        midOrder(root1, queue1);
        midOrder(root2, queue2);

        List<Integer> res = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                res.add(queue2.poll());
                continue;
            }
            if (queue2.isEmpty()) {
                res.add(queue1.poll());
                continue;
            }

            if (queue1.peek() <= queue2.peek()) {
                res.add(queue1.poll());
            } else {
                res.add(queue2.poll());
            }
        }

        return res;
    }

    private void midOrder(TreeNode node, Queue<Integer> queue) {
        if (node == null) {
            return;
        }

        midOrder(node.left, queue);
        queue.offer(node.val);
        midOrder(node.right, queue);
    }
}

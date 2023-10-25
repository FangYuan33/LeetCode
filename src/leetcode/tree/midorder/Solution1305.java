package leetcode.tree.midorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        midOrder(list1, root1);
        LinkedList<Integer> list2 = new LinkedList<>();
        midOrder(list2, root2);

        List<Integer> res = new ArrayList<>();
        while (!list1.isEmpty() || !list2.isEmpty()) {
            if (list1.isEmpty()) {
                res.add(list2.removeFirst());
                continue;
            }
            if (list2.isEmpty()) {
                res.add(list1.removeFirst());
                continue;
            }

            if (list1.peekFirst() < list2.peekFirst()) {
                res.add(list1.removeFirst());
            } else {
                res.add(list2.removeFirst());
            }
        }

        return res;
    }

    private void midOrder(LinkedList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(list, root.left);
        list.addLast(root.val);
        midOrder(list, root.right);
    }
}

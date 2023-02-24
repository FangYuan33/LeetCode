package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionOffer34 {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        preOrder(new LinkedList<>(), root, target);

        return res;
    }

    private void preOrder(LinkedList<Integer> element, TreeNode root, int target) {
        // 结束条件 到达叶子节点
        if (root == null) {
            return;
        }

        element.add(root.val);
        target -= root.val;

        if (root.left == null && root.right == null) {
            if (target == 0) {
                res.add((List) element.clone());
            }
        }

        preOrder(element, root.left, target);
        preOrder(element, root.right, target);

        // 判断完该节点后需移除
        element.removeLast();
    }
}

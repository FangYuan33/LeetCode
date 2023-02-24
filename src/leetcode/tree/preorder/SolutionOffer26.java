package leetcode.tree.preorder;

import leetcode.TreeNode;

public class SolutionOffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        // 当前节点的比较 左子树的比较 右子树的比较
        return doIsSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 先写一个比较当前节点的方法
    private boolean doIsSubStructure(TreeNode A, TreeNode B) {
        // 把B判断没了则是子结构
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return doIsSubStructure(A.left, B.left) && doIsSubStructure(A.right, B.right);
    }
}

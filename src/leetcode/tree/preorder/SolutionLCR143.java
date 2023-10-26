package leetcode.tree.preorder;

import leetcode.TreeNode;

public class SolutionLCR143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return doIsSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean doIsSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return doIsSubStructure(A.left, B.left) && doIsSubStructure(A.right, B.right);
    }
}

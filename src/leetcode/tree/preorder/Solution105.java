package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution105 {

    public static void main(String[] args) {
        new Solution105().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
    }

    HashMap<Integer, Integer> inNodesIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inNodesIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inNodesIndex.put(inorder[i], i);
        }
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int leftP, int rightP,
                                 int[] inorder, int leftI, int rightI) {
        if (leftP > rightP || leftI > rightI) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[leftP]);
        int index = inNodesIndex.get(node.val);
        node.left = doBuildTree(preorder, leftP + 1, leftP + index - leftI, inorder, leftI, index - 1);
        node.right = doBuildTree(preorder, leftP + index - leftI + 1, rightP, inorder, index + 1, rightI);

        return node;
    }
}

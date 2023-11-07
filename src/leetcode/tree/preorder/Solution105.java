package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution105 {

    public static void main(String[] args) {
        new Solution105().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
    }

    HashMap<Integer, Integer> nodeIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        nodeIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.put(inorder[i], i);
        }
        return doBuildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int leftP, int rightP, int leftI, int rightI) {
        if (leftP > rightP || leftI > rightI) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[leftP]);
        // 确定根节点在中序遍历中的索引
        int index = nodeIndex.get(node.val);
        // 根据左子树区间长度确定前序遍历中左右子树的区间范围
        int leftLength = index - leftI;
        node.left = doBuildTree(preorder, leftP + 1, leftP + leftLength, leftI, index - 1);
        node.right = doBuildTree(preorder, leftP + leftLength + 1, rightP, index + 1, rightI);

        return node;
    }
}

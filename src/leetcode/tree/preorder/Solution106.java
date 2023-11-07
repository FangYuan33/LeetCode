package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.HashMap;

public class Solution106 {

    public static void main(String[] args) {
        System.out.println(new Solution106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    HashMap<Integer, Integer> nodeIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        nodeIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.put(inorder[i], i);
        }
        return doBuildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode doBuildTree(int leftI, int rightI, int[] postorder, int leftP, int rightP) {
        if (leftP > rightP) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[rightP]);
        Integer index = nodeIndex.get(node.val);
        int rightLength = rightI - index;
        node.left = doBuildTree(leftI, index - 1, postorder, leftP, rightP - rightLength - 1);
        node.right = doBuildTree(index + 1, rightI, postorder, rightP - rightLength, rightP - 1);
        return node;
    }
}

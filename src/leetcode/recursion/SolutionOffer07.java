package leetcode.recursion;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionOffer07 {
    public static void main(String[] args) {
        TreeNode treeNode = new SolutionOffer07().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        treeNode.print();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList<Integer> pre = new ArrayList<>(preorder.length);
        for (int i : preorder) {
            pre.add(i);
        }
        ArrayList<Integer> in = new ArrayList<>(inorder.length);
        for (int i : inorder) {
            in.add(i);
        }

        return doBuildTree(pre, in);
    }

    private TreeNode doBuildTree(List<Integer> pre, List<Integer> in) {
        if (pre.isEmpty()) {
            return null;
        }

        TreeNode node = new TreeNode(pre.get(0));
        int index = in.indexOf(node.val);
        node.left = doBuildTree(pre.subList(1, index + 1), in.subList(0, index));
        node.right = doBuildTree(pre.subList(index + 1, pre.size()), in.subList(index + 1, pre.size()));

        return node;
    }
}
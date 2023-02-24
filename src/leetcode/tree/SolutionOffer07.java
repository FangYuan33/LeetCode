package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionOffer07 {
    public static void main(String[] args) {
        TreeNode treeNode = new SolutionOffer07().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        treeNode.print();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList<>();
        for (int num : preorder) {
            preList.add(num);
        }
        List<Integer> inList = new ArrayList<>();
        for (int num : inorder) {
            inList.add(num);
        }

        return doBuildTree(preList, inList);
    }

    // 每次都在pre里取值 in只用来定位根节点索引，以此来找右子树
    private TreeNode doBuildTree(List<Integer> preList, List<Integer> inList) {
        if (preList.isEmpty()) {
            return null;
        }

        TreeNode node = new TreeNode(preList.get(0));
        int rootIndex = inList.indexOf(node.val);
        node.left = doBuildTree(preList.subList(1, rootIndex + 1), inList.subList(0, rootIndex));
        node.right = doBuildTree(preList.subList(rootIndex + 1, preList.size()), inList.subList(rootIndex + 1, inList.size()));

        return node;
    }
}
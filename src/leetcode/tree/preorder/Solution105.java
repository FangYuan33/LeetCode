package leetcode.tree.preorder;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList<Integer> preList = new ArrayList<>();
        for (int num : preorder) {
            preList.add(num);
        }
        ArrayList<Integer> inList = new ArrayList<>();
        for (int num : inorder) {
            inList.add(num);
        }

        // 每次都在pre里取值 in只用来定位根节点索引，以此来找右子树
        return doBuildTree(preList, inList);
    }

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

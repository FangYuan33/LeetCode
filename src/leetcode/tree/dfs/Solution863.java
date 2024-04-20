package leetcode.tree.dfs;

import com.sun.source.tree.Tree;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution863 {

    HashMap<TreeNode, TreeNode> parentNode;

    int k;

    List<Integer> res;

    HashSet<TreeNode> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.parentNode = new HashMap<>();
        this.k = k;
        this.visited = new HashSet<>();
        this.res = new ArrayList<>();

        getParent(root);
        dfs(target, 0);

        return res;
    }

    private void getParent(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            parentNode.put(node.left, node);
            getParent(node.left);
        }
        if (node.right != null) {
            parentNode.put(node.right, node);
            getParent(node.right);
        }
    }

    private void dfs(TreeNode node, int step) {
        if (node == null) {
            return;
        }
        visited.add(node);

        if (step == k) {
            res.add(node.val);
            return;
        }

        if (!visited.contains(node.left)) {
            dfs(node.left, step + 1);
        }
        if (!visited.contains(node.right)) {
            dfs(node.right, step + 1);
        }
        if (!visited.contains(parentNode.get(node))) {
            dfs(parentNode.get(node), step + 1);
        }
    }
}

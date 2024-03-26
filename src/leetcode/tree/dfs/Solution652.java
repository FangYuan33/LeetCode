package leetcode.tree.dfs;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution652 {

    List<TreeNode> res;

    HashMap<String, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        recursion(root);

        return res;
    }

    private String recursion(TreeNode root) {
        if (root == null) {
            return " ";
        }

        StringBuilder nodes = new StringBuilder();
        nodes.append(root.val).append("_");
        nodes.append(recursion(root.left)).append(recursion(root.right));

        String key = nodes.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            res.add(root);
        }

        return key;
    }
}

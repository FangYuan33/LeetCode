package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.deserialize(codec.serialize(codec.deserialize("1,|2,3,|null,null,4,5|6,7,|")));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    res.append("null,");
                }
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode node = queue.poll();
            if (!nodes[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[index]));
                node.left = left;
                queue.offer(left);
            }
            index++;
            if (index < nodes.length && !nodes[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[index]));
                node.right = right;
                queue.offer(right);
            }
            index++;
        }

        return root;
    }
}

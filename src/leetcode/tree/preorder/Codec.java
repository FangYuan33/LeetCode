package leetcode.tree.preorder;

import leetcode.TreeNode;

public class Codec {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
//        node2.right = node3;
        Codec codec = new Codec();

        String s = codec.serialize(node2);
        System.out.println(s);

        codec.deserialize(s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            return;
        }

        builder.append(node.val).append(",");
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }

        String[] nodes = data.split(",");
        return preOrder(nodes, 0, nodes.length - 1);
    }

    private TreeNode preOrder(String[] nodes, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[left]));
        int l = left, r = right + 1;
        while (l < r) {
            int mid = l + r >> 1;

            if (Integer.parseInt(nodes[mid]) > node.val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        node.left = preOrder(nodes, left + 1, l - 1);
        node.right = preOrder(nodes, l, right);

        return node;
    }
}

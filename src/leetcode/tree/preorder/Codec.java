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

    private void preOrder(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }

        stringBuilder.append(root.val).append(",");
        preOrder(root.left, stringBuilder);
        preOrder(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }

        String[] nodes = data.split(",");

        return doDeserialize(nodes, 0, nodes.length - 1);
    }

    private TreeNode doDeserialize(String[] nodes, int left, int right) {
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
        node.left = doDeserialize(nodes, left + 1, l - 1);
        node.right = doDeserialize(nodes, l, right);

        return node;
    }
}

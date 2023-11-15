package leetcode.tree.redblacktree;

/**
 * 左倾红黑树 LLRB
 *
 * @author FangYuan
 * @since 2023-11-11 17:48:09
 */
public class LeftLeaningRedBlackTree {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    static class Node {

        int key;

        int value;

        boolean color;

        Node left;

        Node right;

        public Node(int key, int value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;

    /**
     * 左旋
     */
    private Node rotateLeft(Node node) {
        Node newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;

        newNode.color = node.color;
        node.color = RED;

        return newNode;
    }

    /**
     * 右旋
     */
    private Node rotateRight(Node node) {
        Node newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;

        newNode.color = node.color;
        node.color = RED;

        return newNode;
    }

    /**
     * 颜色转换
     */
    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 判断节点是否为红色
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        } else {
            return node.color == RED;
        }
    }
}

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
     * 插入节点
     */
    public void put(Integer key, Integer value) {
        root = put(root, key, value);
        // 根节点永远都是黑色
        root.color = BLACK;
    }

    /**
     * 插入节点的执行逻辑
     */
    private Node put(Node node, Integer key, Integer value) {
        if (node == null) {
            return new Node(key, value, RED);
        }

        if (key > node.key) {
            node.right = put(node.right, key, value);
        } else if (key < node.key) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        // 将3-节点的红链接右引用左旋
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        // 将4-节点两条连续的红链接左引用左旋
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        // 进行颜色转换并将红链接在树中向上传递
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    /**
     * 删除最小节点
     */
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        // 根节点永远都是黑色
        if (root != null) {
            root.color = BLACK;
        }
    }

    /**
     * 删除最小节点
     */
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }

        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);

        return balance(node);
    }

    /**
     * 从右向左借键
     */
    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }

        return node;
    }

    /**
     * 从下到上再平衡
     */
    private Node balance(Node node) {
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

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
    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
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

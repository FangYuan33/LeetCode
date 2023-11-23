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

        // 判断当前节点和左子节点是不是3-节点，不是的话执行借键逻辑
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
        // 兄弟节点为3-节点的情况
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }

        return node;
    }

    /**
     * 删除最大节点
     */
    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMax(root);
        // 根节点永远都是黑色
        if (root != null) {
            root.color = BLACK;
        }
    }

    /**
     * 删除最大节点
     */
    private Node deleteMax(Node node) {
        if (isRed(node.left)) {
            node = rotateRight(node);
        }
        if (node.right == null) {
            return null;
        }

        // 当前节点的右引用不是红链接且右节点不是3-节点
        if (!isRed(node.right) && !isRed(node.right.left)) {
            node = moveRedRight(node);
        }
        node.right = deleteMax(node.right);

        return balance(node);
    }

    /**
     * 从左向右借键
     */
    private Node moveRedRight(Node node) {
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
        }
        return node;
    }

    /**
     * 删除节点
     */
    public void delete(Integer key) {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (root != null) {
            root.color = BLACK;
        }
    }

    /**
     * 删除节点
     */
    private Node delete(Node node, Integer key) {
        if (key < node.key) {
            // 要删除的节点在左子树，保证当前节点为红色
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            // node.right == null 可知上面右旋没有发生，右子树为 null，左节点不是红色节点，能证明左子树必然为null（满足黑色平衡）
            if (key.equals(node.key) && node.right == null) {
                return null;
            }
            // 要删除的节点在右子树
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = moveRedRight(node);
            }

            if (key.equals(node.key)) {
                // 找到右子树中最小的节点替换当前节点的键和值
                Node min = min(node.right);
                node.key = min.key;
                node.value = min.value;
                // 再将该右子树最小的节点移除
                deleteMin(node.right);
            } else {
                node.right = delete(node.right, key);
            }
        }

        return balance(node);
    }

    /**
     * 获取最小节点
     */
    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
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
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        newRoot.color = node.color;
        node.color = RED;

        return newRoot;
    }

    /**
     * 右旋
     */
    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        newRoot.color = node.color;
        node.color = RED;

        return newRoot;
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

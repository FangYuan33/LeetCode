package leetcode.tree.bst;

/**
 * 实现二叉搜索树
 *
 * @author FangYuan
 * @since 2023-11-02 21:06:56
 */
public class BinarySearchTree {


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.putNode(1, 1);
        binarySearchTree.putNode(2, 2);
        binarySearchTree.putNode(3, 3);

//        binarySearchTree.deleteMin();
        binarySearchTree.delete(2);
    }

    static class Node {

        int key;

        int val;

        Node left;

        Node right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 根节点
    Node root;

    /**
     * 根据 key 获取对应的节点值
     */
    public Integer getValue(int key) {
        return getValue(root, key);
    }

    private Integer getValue(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key > node.key) {
            return getValue(node.right, key);
        }
        if (key < node.key) {
            return getValue(node.left, key);
        }
        return node.val;
    }

    /**
     * 将节点插入二叉搜索树中合适的位置
     */
    public void putNode(int key, int val) {
        root = putNode(root, key, val);
    }

    private Node putNode(Node node, int key, int val) {
        if (node == null) {
            return new Node(key, val);
        }

        if (key > node.val) {
            node.right = putNode(node.right, key, val);
        } else if (key < node.val) {
            node.left = putNode(node.left, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    /**
     * 获取最大节点
     */
    public Node getMaxNode() {
        if (root == null) {
            return null;
        }

        return getMaxNode(root);
    }

    private Node getMaxNode(Node node) {
        if (node.right == null) {
            return node;
        }

        return getMaxNode(node.right);
    }

    /**
     * 获取最小节点
     */
    public Node getMinNode() {
        if (root == null) {
            return null;
        }

        return getMinNode(root);
    }

    private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }

        return getMinNode(node.left);
    }

    /**
     * 向下取整查找
     */
    public Node floor(int key) {
        return floor(root, key);
    }

    private Node floor(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key == node.val) {
            return node;
        }
        if (key < node.val) {
            return floor(node.left, key);
        }
        Node right = floor(node.right, key);
        return right != null ? right : node;
    }

    /**
     * 向上取整查找
     */
    public Node ceiling(int key) {
        return ceiling(root, key);
    }

    private Node ceiling(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key == node.val) {
            return node;
        }
        if (key > node.val) {
            return ceiling(node.right, key);
        }
        Node left = ceiling(node.left, key);
        return left != null ? left : node;
    }

    /**
     * 删除最小节点
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(root.left);
        return node;
    }

    /**
     * 删除最大节点
     */
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }

    /**
     * 删除指定节点
     */
    public void delete(int key) {
        root = delete(key, root);
    }

    private Node delete(int key, Node node) {
        if (node == null) {
            return null;
        }

        if (key > node.val) {
            node.right = delete(key, node.right);
            return node;
        }
        if (key < node.val) {
            node.left = delete(key, node.left);
            return node;
        }

        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }
        Node min = getMinNode(node.right);
        min.left = node.left;

        return node;
    }
}

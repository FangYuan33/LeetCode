package leetcode.datastructure;

import java.util.Random;

/**
 * Skiplist class represents a skip list data structure.
 */
public class Skiplist {

    /**
     * The main method creates a Skiplist object, adds elements to it, and searches for an element.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);

        System.out.println(skiplist.search(1));
    }

    int level = 10;

    /**
     * Node class represents a node in the skip list.
     */
    class Node {
        int val;
        Node[] ne = new Node[level];

        /**
         * Constructs a new Node with the given value.
         *
         * @param _val The value to be stored in the node.
         */
        Node(int _val) {
            val = _val;
        }
    }

    Random random = new Random();
    Node he = new Node(-1);

    /**
     * Helper method to find nodes in the skip list.
     *
     * @param t  The target value to search for.
     * @param ns An array of nodes to store the found nodes at each level.
     */
    void find(int t, Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t)
                cur = cur.ne[i];
            ns[i] = cur;
        }
    }

    /**
     * Searches for a value in the skip list.
     *
     * @param t The value to search for.
     * @return True if the value is found, false otherwise.
     */
    public boolean search(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == t;
    }

    /**
     * Inserts a value into the skip list.
     *
     * @param t The value to be inserted.
     */
    public void add(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = new Node(t);
        for (int i = 0; i < level; i++) {
            // Saves the pointer to the next node at each level for the current node
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0)
                break;
        }
    }

    /**
     * Removes a value from the skip list.
     *
     * @param t The value to be removed.
     * @return True if the value is removed, false if the value is not found.
     */
    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != t)
            return false;
        for (int i = 0; i < level && ns[i].ne[i] == node; i++)
            ns[i].ne[i] = ns[i].ne[i].ne[i];
        return true;
    }
}

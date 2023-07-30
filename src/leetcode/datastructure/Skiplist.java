package leetcode.datastructure;

import java.util.Random;

public class Skiplist {

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);

        System.out.println(skiplist.search(1));
    }
    int level = 10;
    class Node {
        int val;
        Node[] ne = new Node[level];
        Node (int _val) {
            val = _val;
        }
    }
    Random random = new Random();
    Node he = new Node(-1);
    void find(int t, Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t) cur = cur.ne[i];
            ns[i] = cur;
        }
    }
    public boolean search(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == t;
    }
    public void add(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = new Node(t);
        for (int i = 0; i < level; i++) {
            // 当前节点保存每一层的当前节点的下一个节点的指针
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0) break;
        }
    }
    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != t) return false;
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) ns[i].ne[i] = ns[i].ne[i].ne[i];
        return true;
    }
}

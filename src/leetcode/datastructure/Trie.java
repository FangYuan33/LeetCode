package leetcode.datastructure;

/**
 * 前缀树 单词查找树 Trie树
 * 它没有保存任何字符，只是记录了字符引用和单词结尾的标志位（isEnd）
 *
 * @author FangYuan
 * @since 2024-02-11 16:40:00
 */
public class Trie {

    static class Node {
        boolean isEnd;
        Node[] next;

        public Node() {
            isEnd = false;
            next = new Node[26];
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        char[] charArray = word.toCharArray();

        for (char c : charArray) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Node();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = doSearch(word);
        return node != null && node.isEnd;
    }

    private Node doSearch(String word) {
        Node node = root;
        char[] charArray = word.toCharArray();

        for (char c : charArray) {
            if (node.next[c - 'a'] == null) {
                return null;
            }
            node = node.next[c - 'a'];
        }

        return node;
    }

    public boolean startsWith(String prefix) {
        Node node = doSearch(prefix);
        return node != null;
    }
}

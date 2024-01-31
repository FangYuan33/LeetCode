package leetcode.graph.algorithms;

import leetcode.graph.algorithms.basic.Digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 深度优先搜索算法顶点排序
 *
 * @author FangYuan
 * @since 2024-01-30 12:49:02
 */
public class DepthFirstOrder {

    private boolean[] marked;

    // 前序
    private Queue<Integer> pre;

    // 后序
    private Queue<Integer> post;

    // 逆后序
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.V()];

        for (int i = 0; i < digraph.V(); i++) {
            if (!marked[i]) {
                dfs(digraph, i);
            }
        }
    }

    private void dfs(Digraph digraph, int i) {
        if (marked[i]) {
            return;
        }

        pre.offer(i);
        marked[i] = true;
        for (Integer v : digraph.adj(i)) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }

        post.offer(i);
        reversePost.push(i);
    }

    public Queue<Integer> pre() {
        return pre;
    }

    public Queue<Integer> post() {
        return post;
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }
}

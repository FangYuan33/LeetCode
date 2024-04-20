package leetcode.graph;

import leetcode.utils.Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1519 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution1519().countSubTrees(5, Matrix.convert("[[0,1],[0,2],[1,3],[0,4]]"), "aabab")));
    }

    ArrayList<Integer>[] adj;
    
    boolean[] visited;

    int[] res;

    char[] labelsCharArray;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        if (n == 1) {
            return new int[]{1};
        }
        res = new int[n];
        visited = new boolean[n];
        labelsCharArray = labels.toCharArray();

        adj = new ArrayList[n];
        for (int[] edge : edges) {
            if (adj[edge[0]] == null) {
                adj[edge[0]] = new ArrayList<>();
            }
            if (adj[edge[1]] == null) {
                adj[edge[1]] = new ArrayList<>();  
            }
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(0);

        return res;
    }
    
    private int[] dfs(int v) {
        visited[v] = true;

        int[] count = new int[26];
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                int[] t = dfs(w);
                // 把遍历过的点都统计上
                for (int i = 0; i < count.length; i++) {
                    count[i] += t[i];
                }
            }
        }

        // 统计上自身的点数
        count[labelsCharArray[v] - 'a']++;
        // 标记在答案中
        res[v] += count[labelsCharArray[v] - 'a'];
        return count;
    }
}

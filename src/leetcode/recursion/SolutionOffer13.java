package leetcode.recursion;

public class SolutionOffer13 {
    private int m;
    private int n;
    private int k;
    private int res = 0;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;

        // 这个可能会重复，所以需要 boolean[][] visited 来记录
        recursion(0, 0, new boolean[m][n]);

        return res;
    }

    private void recursion(int row, int column, boolean[][] visited) {
        // 结束条件：越界、超过规定的k值、已经访问过
        if (row >= m || column >= n || row % 10 + row / 10 % 10 + column % 10 + column / 10 % 10 > k || visited[row][column]) {
            return;
        }

        // 到达某个格子结果加1
        res++;
        visited[row][column] = true;

        // 向下向右跑
        recursion(row + 1, column, visited);
        recursion(row, column + 1, visited);
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer13().movingCount(2, 3, 1));
    }
}

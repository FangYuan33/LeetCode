package leetcode.recursion;

public class SolutionLCR130 {

    int res;

    int cnt;

    int m;

    int n;

    public int wardrobeFinishing(int m, int n, int cnt) {
        this.res = 0;
        this.cnt = cnt;
        this.m = m;
        this.n = n;

        recursion(0, 0, new boolean[m][n]);

        return res;
    }

    private void recursion(int m, int n, boolean[][] visited) {
        if (m >= this.m || n >= this.n || visited[m][n]
                || m % 10 + m / 10 % 10 + n % 10 + n / 10 % 10 > this.cnt) {
            return;
        }
        res++;
        visited[m][n] = true;
        recursion(m + 1, n, visited);
        recursion(m, n + 1, visited);
    }
}

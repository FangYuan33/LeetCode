package leetcode.binaryindexedtree;

public class Solution1395 {

    // 使用线段树在长为 1e5 标记出现过的数字
    // 那么这样在发生 大于或小于 时，统计这个区间内被标记为 1 的数即可
    public int numTeams(int[] rating) {
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree();
        int res = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    res += binaryIndexedTree.query(rating[i], rating[j]);
                } else {
                    res += binaryIndexedTree.query(rating[j], rating[i]);
                }

                binaryIndexedTree.update(rating[j], 1);
            }
            // 遍历完本组数后把树状数组恢复
            for (int j = i + 1; j < rating.length; j++) {
                binaryIndexedTree.update(rating[j], -1);
            }
        }

        return res;
    }

    static class BinaryIndexedTree {

        private static final int N = (int) 1e5 + 1;

        int[] tree;

        public BinaryIndexedTree() {
            this.tree = new int[N];
        }

        public void update(int num, int val) {
            for (int i = num; i < N; i += lowbit(i)) {
                tree[i] += val;
            }
        }

        public int query(int left, int right) {
            return query(right - 1) - query(left);
        }

        private int query(int n) {
            int res = 0;
            for (int i = n; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        private int lowbit(int x) {
            return x & -x;
        }
    }
}

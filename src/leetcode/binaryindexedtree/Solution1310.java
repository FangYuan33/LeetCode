package leetcode.binaryindexedtree;

public class Solution1310 {

    public static void main(String[] args) {
        new Solution1310().xorQueries(new int[]{1, 3, 4, 8}, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 3}, new int[]{3, 3}});
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(arr);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = binaryIndexedTree.query(queries[i][0] + 1, queries[i][1] + 1);
        }

        return res;
    }

    static class BinaryIndexedTree {
        // 用这颗树来保存异或的结果值
        int[] tree;

        int[] arr;

        public BinaryIndexedTree(int[] arr) {
            this.arr = arr;
            tree = new int[arr.length + 1];

            for (int i = 0; i < arr.length; i++) {
                calculate(i + 1, arr[i]);
            }
        }

        private void calculate(int index, int num) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] ^= num;
            }
        }

        public int query(int left, int right) {
            return query(right) ^ query(left - 1);
        }

        private int query(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                res ^= tree[i];
            }

            return res;
        }

        private int lowbit(int x) {
            return x & -x;
        }
    }
}

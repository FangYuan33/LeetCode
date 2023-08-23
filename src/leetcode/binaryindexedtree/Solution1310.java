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

        int[] tree;

        public BinaryIndexedTree(int[] nums) {
            this.tree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                update(i + 1, nums[i]);
            }
        }

        public int query(int left, int right) {
            return query(right) ^ query(left - 1);
        }

        public int query(int i) {
            int res = 0;
            for (int j = i; j > 0; j -= lowbit(j)) {
                res ^= tree[j];
            }

            return res;
        }

        private void update(int i, int num) {
            for (int j = i; j < tree.length; j += lowbit(j)) {
                tree[j] ^= num;
            }
        }

        private int lowbit(int j) {
            return j & -j;
        }
    }

}

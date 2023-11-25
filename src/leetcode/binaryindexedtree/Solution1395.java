package leetcode.binaryindexedtree;

public class Solution1395 {

    public static void main(String[] args) {
        System.out.println(new Solution1395().numTeams(new int[]{2, 5, 3, 4, 1}));
    }

    public int numTeams(int[] rating) {
        int[] left = new int[rating.length];
        BinaryIndexedTree tree = new BinaryIndexedTree();
        for (int i = 0; i < rating.length; i++) {
            left[i] = tree.query(rating[i]);
            tree.update(rating[i], 1);
        }
        int[] right = new int[rating.length];
        BinaryIndexedTree tree2 = new BinaryIndexedTree();
        for (int i = rating.length - 1; i >= 0; i--) {
            right[i] = tree2.queryResult(rating[i], (int) 1e5);
            tree2.update(rating[i], 1);
        }

        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            res += left[i] * right[i];
            res += (i - left[i]) * (rating.length - i - 1 - right[i]);
        }

        return res;
    }

    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            this.tree = new int[(int) 1e5 + 1];
        }

        public void update(int index, int val) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += val;
            }
        }

        public int queryResult(int left, int right) {
            return query(right) - query(left - 1);
        }

        public int query(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }
            return res;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

package leetcode.binaryindexedtree;

public class Solution1395 {

    public static void main(String[] args) {
        System.out.println(new Solution1395().numTeams(new int[]{2, 5, 3, 4, 1}));
    }

    public int numTeams(int[] rating) {
        int res = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree();
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    res += tree.queryResult(rating[i], rating[j]);
                }
                if (rating[i] > rating[j]) {
                    res += tree.queryResult(rating[j], rating[i]);
                }
                tree.update(rating[j], 1);
            }

            for (int j = i + 1; j < rating.length; j++) {
                tree.update(rating[j], - 1);
            }
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

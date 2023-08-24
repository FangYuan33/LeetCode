package leetcode.binaryindexedtree;

public class Solution1395 {

    public static void main(String[] args) {
        System.out.println(new Solution1395().numTeams(new int[]{2, 5, 3, 4, 1}));
    }

    // 本题的思路是固定 i 和 k 士兵，查询在 [i, k] 区间内有多少 j 士兵
    // 区间查找和单点修改，符合线段树的用法
    public int numTeams(int[] rating) {
        BinaryIndexedTree tree = new BinaryIndexedTree();

        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int k = i + 1; k < rating.length; k++) {
                if (rating[i] < rating[k]) {
                    res += tree.query(rating[i], rating[k]);
                }
                if (rating[i] > rating[k]) {
                    res += tree.query(rating[k], rating[i]);
                }

                // 标记 rating[j] 士兵
                tree.update(rating[k], 1);
            }

            // 将 i + 1 标记过的士兵全部取消标记
            for (int j = i + 1; j < rating.length; j++) {
                tree.update(rating[j], -1);
            }
        }

        return res;
    }

    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            this.tree = new int[(int) 1e5 + 1];
        }

        public int query(int left, int right) {
            return query(right) - query(left);
        }

        public int query(int num) {
            int res = 0;
            for (int i = num; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        public void update(int num, int val) {
            for (int i = num; i < tree.length; i += lowbit(i)) {
                tree[i] += val;
            }
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

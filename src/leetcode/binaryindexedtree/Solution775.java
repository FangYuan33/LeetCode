package leetcode.binaryindexedtree;

public class Solution775 {

    public boolean isIdealPermutation(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        // 出现的数字全部入线段树，查询到的以当前数为左边界开区间的数量即为全局倒置数量
        int all = 0;
        int local = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree(nums.length);
        tree.update(nums[0] + 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                local++;
            }
            all += tree.queryNm(nums[i] + 1);

            tree.update(nums[i] + 1);
        }

        return local == all;
    }

    // 涉及单点更新和区间查询
    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree(int n) {
            this.tree = new int[n + 1];
        }

        public int queryNm(int index) {
            return query(tree.length - 1) - query(index);
        }

        public int query(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        public void update(int index) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += 1;
            }
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }

}

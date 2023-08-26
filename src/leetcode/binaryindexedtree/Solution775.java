package leetcode.binaryindexedtree;

public class Solution775 {

    public static void main(String[] args) {
        new Solution775().isIdealPermutation(new int[]{0, 1});
    }

    // 全局倒置即为查询当前数字后边有多少个数字出现
    public boolean isIdealPermutation(int[] nums) {
        BinaryIndexedTree tree = new BinaryIndexedTree(nums.length);
        int local = 0, all = 0;
        tree.update(nums[0] + 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                local++;
            }
            all += tree.queryNum(nums[i] + 1);
            tree.update(nums[i] + 1);
        }

        return local == all;
    }

    // 单点修改和区间查询
    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree(int n) {
            tree = new int[n + 1];
        }

        public int queryNum(int x) {
            return query(tree.length - 1) - query(x - 1);
        }

        public int query(int x) {
            int res = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
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

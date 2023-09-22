package leetcode.binaryindexedtree;

public class Solution775 {

    public static void main(String[] args) {
        System.out.println(new Solution775().isIdealPermutation(new int[]{1, 0, 2}));
    }

    public boolean isIdealPermutation(int[] nums) {
        BinaryIndexedTree tree = new BinaryIndexedTree(nums.length);

        int all = 0, local = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] > nums[i]) {
                local++;
            }
            all += tree.query(nums[i] + 1, nums.length);
            tree.update(nums[i] + 1, 1);
        }

        return all == local;
    }

    static class BinaryIndexedTree {
        int[] tree;

        public BinaryIndexedTree(int n) {
            this.tree = new int[n + 1];
        }

        public int query(int left, int right) {
            return query(right) - query(left - 1);
        }

        public int query(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        public void update(int index, int val) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += val;
            }
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

package leetcode.binaryindexedtree;

public class Solution775 {

    public static void main(String[] args) {
        System.out.println(new Solution775().isIdealPermutation(new int[]{1, 0, 2}));
    }

    public boolean isIdealPermutation(int[] nums) {
        BinaryIndexedTree tree = new BinaryIndexedTree();

        int local = 0;
        int all = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] > nums[i]) {
                local++;
            }
            all += tree.queryNum(nums[i] + 1);
            tree.update(nums[i] + 1);
        }

        return local == all;
    }

    static class BinaryIndexedTree {
        int[] tree;

        public BinaryIndexedTree() {
            tree = new int[(int) 1e5 + 1];
        }

        public int queryNum(int index) {
            return query((int) 1e5) - query(index - 1);
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

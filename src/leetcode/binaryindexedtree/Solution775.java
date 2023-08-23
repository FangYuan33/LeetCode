package leetcode.binaryindexedtree;

public class Solution775 {

    // 局部倒置比较好算，遍历的时候计算前边的是否比当前的大就可以
    // 全局倒置查找当前节点前比自己大的节点的个数，本质上两种都是计算逆序对
    public boolean isIdealPermutation(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        BinaryIndexedTree tree = new BinaryIndexedTree(nums.length);
        tree.update(nums[0] + 1);

        int local = 0;
        int all = 0;
        for (int i = 1; i < nums.length; i++) {
            // 统计局部倒置
            if (nums[i - 1] > nums[i]) {
                local++;
            }

            all += tree.queryNum(nums[i] + 1);
            tree.update(nums[i] + 1);
        }

        return local == all;
    }

    // 因为数值范围是 [0, n - 1]，那么我们可以标记具体数字有没有出现，出现即为 1，未出现则为 0，这样我们就能查询出比当前节点大的数字的数量了
    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree(int n) {
            this.tree = new int[n + 1];
        }

        public void update(int num) {
            for (int i = num; i < tree.length; i += lowbit(i)) {
                tree[i] += 1;
            }
        }

        public int queryNum(int num) {
            return query(tree.length - 1) - query(num);
        }

        public int query(int num) {
            int res = 0;
            for (int i = num; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

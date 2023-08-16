package leetcode.binaryindexedtree;

public class Solution775 {

    public static void main(String[] args) {
        System.out.println(new Solution775().isIdealPermutation(new int[]{1, 2, 0}));
    }

    // 本题的解题关键是查找逆序对，那么我们计算某个数前边出现过多少个比它大的值就可以了
    public boolean isIdealPermutation(int[] nums) {
        // 全局
        int count1 = 0;
        // 局部
        int count2 = 0;
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i - 1]) {
                count2++;
            }
            count1 += binaryIndexedTree.queryNum(nums[i]);
            binaryIndexedTree.update(nums[i]);
        }

        return count1 == count2;
    }

    class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree(int n) {
            this.tree =  new int[n + 1];
        }

        // 记录的是 num + 1 位置的数量，否则 num 为 0 时会死循环
        public void update(int num) {
            for (int i = num + 1; i < tree.length; i += lowbit(i)) {
                tree[i]++;
            }
        }

        // 查询的是当前数之后的数量
        public int queryNum(int num) {
            return query(tree.length - 1) - query(num);
        }


        private int query(int num) {
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

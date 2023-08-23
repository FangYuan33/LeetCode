package leetcode.binaryindexedtree;

import java.util.*;

public class Solution327 {

    public static void main(String[] args) {
        System.out.println(new Solution327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    // 若我们处理到位置 k，以 k 为右端点的前缀和为 s，那么以 nums[k] 为右端点的合法子数组个数，
    // 等价于在下标 [0, k - 1] 中前缀和范围在 [s - upper, s - lower] 的数的个数
    //
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 前缀和计算
        HashSet<Long> set = new HashSet<>();
        long preSum = 0L;
        set.add(preSum);
        for (int num : nums) {
            preSum += num;

            set.add(preSum);
            set.add(preSum - upper);
            set.add(preSum - lower);
        }
        // 排序并离散化
        ArrayList<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }

        BinaryIndexedTree tree = new BinaryIndexedTree();
        preSum = 0;
        tree.add(map.get(preSum), 1);
        int res = 0;
        for (int num : nums) {
            preSum += num;
            Integer right = map.get(preSum - lower);
            Integer left = map.get(preSum - upper);

            res += tree.query(left, right);
            tree.add(map.get(preSum), 1);
        }

        return res;
    }

    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            this.tree = new int[100010 * 3];
        }

        public void add(int index, int val) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += val;
            }
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

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

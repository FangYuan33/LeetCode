package leetcode.binaryindexedtree;

import java.util.*;

public class Solution327 {

    public static void main(String[] args) {
        System.out.println(new Solution327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long preSum = 0;
        Set<Long> set = new HashSet<>();
        set.add(preSum);
        for (int num : nums) {
            preSum += num;

            set.add(preSum);
            set.add(preSum - upper);
            set.add(preSum - lower);
        }
        ArrayList<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        HashMap<Long, Integer> sumIndex = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            sumIndex.put(list.get(i), i + 1);
        }

        preSum = 0L;
        BinaryIndexedTree tree = new BinaryIndexedTree();
        tree.update(sumIndex.get(preSum));
        int res = 0;
        for (int num : nums) {
            preSum += num;
            long left = preSum - upper;
            long right = preSum - lower;
            res += tree.query(sumIndex.get(left), sumIndex.get(right));
            tree.update(sumIndex.get(preSum));
        }

        return res;
    }

    static class BinaryIndexedTree {
        int[] tree;

        public BinaryIndexedTree() {
            this.tree = new int[(int) 3e5 + 1];
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

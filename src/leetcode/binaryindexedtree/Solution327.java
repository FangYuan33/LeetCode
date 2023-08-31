package leetcode.binaryindexedtree;

import java.util.*;

public class Solution327 {

    public static void main(String[] args) {
        System.out.println(new Solution327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long preSum = 0;
        HashSet<Long> set = new HashSet<>();

        set.add(preSum);
        for (int num : nums) {
            preSum += num;

            set.add(preSum);
            set.add(preSum - upper);
            set.add(preSum - lower);
        }
        ArrayList<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        HashMap<Long, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            valueIndex.put(list.get(i), i + 1);
        }

        int res = 0;
        preSum = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree();
        tree.update(valueIndex.get(0L));
        for (int num : nums) {
            preSum += num;

            res += tree.query(valueIndex.get(preSum - upper), valueIndex.get(preSum - lower));

            tree.update(valueIndex.get(preSum));
        }

        return res;
    }

    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            tree = new int[(int) 3e5 + 1];
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

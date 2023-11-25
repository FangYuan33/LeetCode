package leetcode.binaryindexedtree;

import java.util.HashMap;

public class Solution2179 {

    public static void main(String[] args) {
        System.out.println(new Solution2179().goodTriplets(new int[]{13, 14, 10, 2, 12, 3, 9, 11, 15, 8, 4, 7, 0, 6, 5, 1},
                new int[]{8, 7, 9, 5, 6, 14, 15, 10, 2, 11, 4, 13, 3, 12, 1, 0}));
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> num1Index = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            num1Index.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = num1Index.get(nums2[i]) + 1;
        }

        // 统计左边小于当前值元素的个数
        int[] left = new int[nums2.length];
        BinaryIndexedTree tree = new BinaryIndexedTree();
        for (int i = 0; i < nums2.length; i++) {
            left[i] = tree.query(nums2[i]);
            tree.update(nums2[i], 1);
        }
        // 统计右边大于当前元素的个数
        BinaryIndexedTree tree2 = new BinaryIndexedTree();
        int[] right = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            right[i] = tree2.query(nums2[i], nums2.length);
            tree2.update(nums2[i], 1);
        }

        long res = 0;
        for (int i = 0; i < nums2.length; i++) {
            res += (long) left[i] * right[i];
        }

        return res;
    }

    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            this.tree = new int[(int) 1e5 + 2];
        }

        public int query(int left, int right) {
            return query(right) - query(left - 1);
        }

        private int query(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
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

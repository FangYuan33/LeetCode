package leetcode.segmenttree;

public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 把所有的区间和都计算出来，封装结果时判断结果在 lower 和 upper 之间
        // 每个值的范围很大，求和时可能会发生溢出，所以我们需要使用 long 类型来计算
        SegmentTree segmentTree = new SegmentTree(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sum = segmentTree.query(1, i + 1, j + 1);
                if (sum >= lower && sum <= upper) {
                    res++;
                }
            }
        }

        return res;
    }

    static class SegmentTree {

        static class Node {

            long val;

            int left;

            int right;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        Node[] tree;

        long[] nums;

        public SegmentTree(int[] nums) {
            this.nums = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                this.nums[i] = nums[i];
            }
            tree = new Node[nums.length * 4];

            build(1, 1, nums.length);
        }

        private void build(int pos, int left, int right) {
            tree[pos] = new Node(left, right);
            if (left == right) {
                tree[pos].val = nums[left];
                return;
            }

            int mid = left + right >> 1;
            build(pos << 1, left, mid);
            build(pos << 1 | 1, mid + 1, right);

            pushUp(pos);
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }

        public long query(int pos, int left, int right) {
            if (tree[pos].left == left && tree[pos].right == right) {
                return tree[pos].val;
            }

            int mid = left + right >> 1;
            if (right <= mid) {
                return query(pos << 1, left, right);
            } else if (left > mid) {
                return query(pos << 1 | 1, left, right);
            } else {
                return query(pos << 1, left, mid) + query(pos << 1 | 1, mid + 1, right);
            }
        }
    }
}

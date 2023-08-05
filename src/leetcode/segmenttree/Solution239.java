package leetcode.segmenttree;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        SegmentTree segmentTree = new SegmentTree(nums);

        for (int i = 0; i < res.length; i++) {
            res[i] = segmentTree.query(1, i + 1, i + k);
        }

        return res;
    }

    static class SegmentTree {
        static class Node {
            int val;

            int left;

            int right;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        private int[] nums;

        private Node[] tree;

        public SegmentTree(int[] nums) {
            this.nums = nums;
            tree = new Node[nums.length * 4];
            // 构建树
            build(1, 1, nums.length);
        }

        private void build(int pos, int left, int right) {
            tree[pos] = new Node(left, right);
            if (left == right) {
                tree[pos].val = nums[left - 1];
                return;
            }

            // 非叶子节点
            int mid = left + right >> 1;
            build(pos << 1, left, mid);
            build(pos << 1 | 1, mid + 1, right);

            // 叶子节点构建完毕后，需要修改当前节点的值
            pushUp(pos);
        }

        private void pushUp(int pos) {
            // 取左右子树的大值
            tree[pos].val = Math.max(tree[pos << 1].val, tree[pos << 1 | 1].val);
        }

        private int query(int pos, int left, int right) {
            if (tree[pos].left == left && tree[pos].right == right) {
                return tree[pos].val;
            }

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (right <= mid) {
                return query(pos << 1, left, right);
            } else if (left > mid) {
                return query(pos << 1 | 1, left, right);
            } else {
                return Math.max(query(pos << 1, left, mid), query(pos << 1 | 1, mid + 1, right));
            }
        }
    }
}

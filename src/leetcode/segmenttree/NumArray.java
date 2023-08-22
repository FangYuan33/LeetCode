package leetcode.segmenttree;

public class NumArray {

    private SegmentTree segmentTree;

    // 单点修改和区间查询
    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        segmentTree.update(1, index + 1, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(1, left + 1, right + 1);
    }

    static class SegmentTree {

        static class Node {

            int left;

            int right;

            int val;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        Node[] tree;

        int[] nums;

        public SegmentTree(int[] nums) {
            this.nums = nums;
            tree = new Node[nums.length * 4];

            build(1, 1, nums.length);
        }

        private void build(int pos, int left, int right) {
            tree[pos] = new Node(left, right);
            if (tree[pos].left == tree[pos].right) {
                tree[pos].val = nums[left - 1];
                return;
            }

            int mid = left + right >> 1;
            build(pos << 1, left, mid);
            build(pos << 1 | 1, mid + 1, right);

            pushUp(pos);
        }

        public int query(int pos, int left, int right) {
            if (left <= tree[pos].left && tree[pos].right <= right) {
                return tree[pos].val;
            }

            int res = 0;
            int mid = tree[pos].left + tree[pos].right >> 1;
            if (left <= mid) {
                res += query(pos << 1, left, right);
            }
            if (right > mid) {
                res += query(pos << 1 | 1, left, right);
            }

            return res;
        }

        public void update(int pos, int numPos, int val) {
            if (tree[pos].left == numPos && tree[pos].right == numPos) {
                tree[pos].val = val;
                nums[numPos - 1] = val;

                return;
            }

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (numPos <= mid) {
                update(pos << 1, numPos, val);
            } else {
                update(pos << 1 | 1, numPos, val);
            }

            pushUp(pos);
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }
    }
}


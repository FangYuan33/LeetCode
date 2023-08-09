package leetcode.segmenttree;

public class NumArray {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{0, 9, 5, 7, 3});

        System.out.println(numArray.sumRange(1, 2));
    }

    SegmentTree segmentTree;

    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        segmentTree.update(1, index + 1, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.sumRange(1, left + 1, right + 1);
    }

    static class SegmentTree {

        static class Node {

            // 区间和
            int val;

            int left;

            int right;

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
            // 建树
            build(1, 1, nums.length);
        }

        public void build(int pos, int left, int right) {
            tree[pos] = new Node(left, right);
            if (left == right) {
                tree[pos].val = nums[left - 1];
                return;
            }

            int mid = left + right >> 1;
            // 左右子树
            build(pos << 1, left, mid);
            build(pos << 1 | 1, mid + 1, right);

            // 递归更新值
            pushUp(pos);
        }

        private void pushUp(int pos) {
            // 求和
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }

        public void update(int pos, int numPos, int val) {
            if (numPos <= 0 || numPos > nums.length) {
                return;
            }

            // 找到了
            if (tree[pos].left == numPos && tree[pos].right == numPos) {
                tree[pos].val = val;
                return;
            }

            // 找
            int mid = tree[pos].left + tree[pos].right >> 1;
            if (numPos > mid) { // 右边找
                update(pos << 1 | 1, numPos, val);
            } else { // 左边找
                update(pos << 1, numPos, val);
            }

            // 叶子节点修改完了，需要向上回溯修改父节点的值
            pushUp(pos);
        }

        public int sumRange(int pos, int left, int right) {
            if (tree[pos].left == left && tree[pos].right == right) {
                return tree[pos].val;
            }

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (right <= mid) { // 全在左边
                return sumRange(pos << 1, left, right);
            } else if (left > mid) { // 全在右边
                return sumRange(pos << 1 | 1, left, right);
            } else { // 两边都有
                return sumRange(pos << 1, left, mid) + sumRange(pos << 1 | 1, mid + 1, right);
            }
        }
    }
}


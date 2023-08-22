package leetcode.segmenttree;

public class Solution1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        SegmentTree segmentTree = new SegmentTree();

        for (int[] range : ranges) {
            segmentTree.update(1, range[0], range[1]);
        }

        return segmentTree.query(1, left, right) == (right - left + 1);
    }

    // 区间修改和区间查询
    static class SegmentTree {
        static class Node {

            int left;

            int right;

            int val;

            int add;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        Node[] tree;

        public SegmentTree() {
            tree = new Node[200];
            build(1, 1, 50);
        }

        private void build(int pos, int left, int right) {
            tree[pos] = new Node(left, right);
            if (left == right) {
                return;
            }

            int mid = left + right >> 1;
            build(pos << 1, left, mid);
            build(pos << 1 | 1, mid + 1, right);
        }

        public void update(int pos, int left, int right) {
            if (left <= tree[pos].left && tree[pos].right <= right) {
                tree[pos].val = tree[pos].right - tree[pos].left + 1;
                tree[pos].add = 1;
                return;
            }

            pushDown(pos);

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (left <= mid) {
                update(pos << 1, left, right);
            }
            if (right > mid) {
                update(pos << 1 | 1, left, right);
            }

            pushUp(pos);
        }

        public int query(int pos, int left, int right) {
            if (left <= tree[pos].left && tree[pos].right <= right) {
                return tree[pos].val;
            }

            pushDown(pos);

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

        private void pushDown(int pos) {
            if (tree[pos].left != tree[pos].right && tree[pos].add != 0) {
                tree[pos << 1].val = tree[pos << 1].right - tree[pos << 1].left + 1;
                tree[pos << 1 | 1].val = tree[pos << 1 | 1].right - tree[pos << 1 | 1].left + 1;

                tree[pos << 1].add = 1;
                tree[pos << 1 | 1].add = 1;

                tree[pos].add = 0;
            }
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }
    }
}

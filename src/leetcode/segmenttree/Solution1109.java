package leetcode.segmenttree;

public class Solution1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        SegmentTree segmentTree = new SegmentTree(n);

        for (int[] booking : bookings) {
            segmentTree.update(1, booking[0], booking[1], booking[2]);
        }

        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = segmentTree.query(1, i + 1, i + 1);
        }

        return res;
    }

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

        public SegmentTree(int n) {
            this.tree = new Node[n * 4];
            build(1, 1, n);
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

        public void update(int pos, int left, int right, int val) {
            if (left <= tree[pos].left && tree[pos].right <= right) {
                tree[pos].val += val * (tree[pos].right - tree[pos].left + 1);
                tree[pos].add += val;
                return;
            }

            pushDown(pos);

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (left <= mid) {
                update(pos << 1, left, right, val);
            }
            if (right > mid) {
                update(pos << 1 | 1, left, right, val);
            }

            pushUp(pos);
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }

        private void pushDown(int pos) {
            if (tree[pos].left != tree[pos].right && tree[pos].add != 0) {
                int add = tree[pos].add;

                tree[pos << 1].val += add * (tree[pos << 1].right - tree[pos << 1].left + 1);
                tree[pos << 1 | 1].val += add * (tree[pos << 1 | 1].right - tree[pos << 1 | 1].left + 1);

                tree[pos << 1].add += add;
                tree[pos << 1 | 1].add += add;

                tree[pos].add = 0;
            }
        }
    }
}

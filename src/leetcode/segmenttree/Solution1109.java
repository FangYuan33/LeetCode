package leetcode.segmenttree;

public class Solution1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        SegmentTree segmentTree = new SegmentTree();

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

        public SegmentTree() {
            // 先把树准备好
            tree = new Node[(int) 8e4];
            build(1, 1, (int) 2e4);
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

        public void update(int pos, int left, int right, int add) {
            if (left <= tree[pos].left && tree[pos].right <= right) {
                tree[pos].val += add * (tree[pos].right - tree[pos].left + 1);
                tree[pos].add += add;
                return;
            }

            pushDown(pos);

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (left <= mid) {
                update(pos << 1, left, right, add);
            }
            if (right > mid) {
                update(pos << 1 | 1, left, right, add);
            }

            pushUp(pos);
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }

        public int query(int pos, int left, int right) {
            if (left <= tree[pos].left && tree[pos].right <= right) {
                return tree[pos].val;
            }

            pushDown(pos);

            int mid = tree[pos].left + tree[pos].right >> 1;
            int res = 0;
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
                int mid = tree[pos].left + tree[pos].right >> 1;
                int add = tree[pos].add;

                tree[pos << 1].val += add * (mid - tree[pos].left + 1);
                tree[pos << 1 | 1].val += add * (tree[pos].right - mid);

                tree[pos << 1].add += add;
                tree[pos << 1 | 1].add += add;

                tree[pos].add = 0;
            }
        }
    }
}

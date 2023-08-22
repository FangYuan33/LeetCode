package leetcode.segmenttree;

public class MyCalendar {

    private SegmentTree segmentTree;

    public MyCalendar() {
        segmentTree = new SegmentTree();
    }

    public boolean book(int start, int end) {
        if (segmentTree.query(1, 1, (int) 1e9, start + 1, end) > 0) {
            return false;
        }
        segmentTree.update(1, 1, (int) 1e9, start + 1, end, 1);

        return true;
    }

    static class SegmentTree {
        static class Node {
            int left;

            int right;

            int val;

            int add;

        }

        Node[] tree;

        int count;

        public SegmentTree() {
            count = 1;
            tree = new Node[(int) 5e6];
        }

        public void update(int pos, int left, int right, int l, int r, int val) {
            if (l <= left && right <= r) {
                tree[pos].val += (right - left + 1) * val;
                tree[pos].add += val;

                return;
            }

            lazyCreate(pos);
            pushDown(pos, (right - left + 1));

            int mid = left + right >> 1;
            if (l <= mid) {
                update(tree[pos].left, left, mid, l, r, val);
            }
            if (r > mid) {
                update(tree[pos].right, mid + 1, right, l, r, val);
            }

            pushUp(pos);
        }

        public int query(int pos, int left, int right, int l, int r) {
            if (l <= left && right <= r) {
                return tree[pos].val;
            }

            lazyCreate(pos);

            pushDown(pos, (right - left) + 1);

            int res = 0;
            int mid = left + right >> 1;
            if (l <= mid) {
                res += query(tree[pos].left, left, mid, l, r);
            }
            if (r > mid) {
                res += query(tree[pos].right, mid + 1, right, l, r);
            }

            return res;
        }

        private void lazyCreate(int pos) {
            if (tree[pos] == null) {
                tree[pos] = new Node();
            }

            if (tree[pos].left == 0) {
                tree[pos].left = ++count;
                tree[tree[pos].left] = new Node();
            }
            if (tree[pos].right == 0) {
                tree[pos].right = ++count;
                tree[tree[pos].right] = new Node();
            }
        }

        private void pushDown(int pos, int length) {
            if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
                tree[tree[pos].left].val += tree[pos].add * (length - length / 2);
                tree[tree[pos].right].val += tree[pos].add * length / 2;

                tree[tree[pos].left].add += tree[pos].add;
                tree[tree[pos].right].add += tree[pos].add;

                tree[pos].add = 0;
            }
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[tree[pos].left].val + tree[tree[pos].right].val;
        }
    }
}
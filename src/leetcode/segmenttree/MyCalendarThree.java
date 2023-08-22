package leetcode.segmenttree;

public class MyCalendarThree {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(0, 1000000000);
    }

    SegmentTree segmentTree;

    int max = 0;

    public MyCalendarThree() {
        segmentTree = new SegmentTree();
    }

    public int book(int startTime, int endTime) {
        segmentTree.update(1, 1, (int) 1e9, startTime + 1, endTime);
        max = Math.max(max, segmentTree.query(1, 1, (int) 1e9, startTime + 1, endTime));

        return max;
    }

    // 同样是保存区间最大值的动态开点线段树
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
            tree = new Node[(int) 5e6];
            count = 1;
            tree[count] = new Node();
        }

        public int query(int pos, int left, int right, int l, int r) {
            if (l <= left && right <= r) {
                return tree[pos].val;
            }

            lazyCreate(pos);

            pushDown(pos);

            int res = 0;
            int mid = left + right >> 1;
            if (l <= mid) {
                res = Math.max(res, query(tree[pos].left, left, mid, l, r));
            }
            if (r > mid) {
                res = Math.max(res, query(tree[pos].right, mid + 1, right, l, r));
            }

            return res;
        }

        public void update(int pos, int left, int right, int l, int r) {
            if (l <= left && right <= r) {
                tree[pos].val++;
                tree[pos].add++;
                return;
            }

            lazyCreate(pos);

            pushDown(pos);

            int mid = left + right >> 1;
            if (l <= mid) {
                update(tree[pos].left, left, mid, l, r);
            }
            if (r > mid) {
                update(tree[pos].right, mid + 1, right, l, r);
            }

            pushUp(pos);
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

        private void pushDown(int pos) {
            if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
                int add = tree[pos].add;

                tree[tree[pos].left].val += add;
                tree[tree[pos].right].val += add;

                tree[tree[pos].left].add += add;
                tree[tree[pos].right].add += add;

                tree[pos].add = 0;
            }
        }

        private void pushUp(int pos) {
            tree[pos].val = Math.max(tree[tree[pos].left].val, tree[tree[pos].right].val);
        }
    }
}

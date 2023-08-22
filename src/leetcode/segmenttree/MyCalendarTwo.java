package leetcode.segmenttree;


public class MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();

        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(50, 60));
        System.out.println(calendar.book(10, 40));
        System.out.println(calendar.book(5, 15));
        System.out.println(calendar.book(5, 10));
        System.out.println(calendar.book(25, 55));
    }


    SegmentTree segmentTree;

    public MyCalendarTwo() {
        segmentTree = new SegmentTree();
    }

    public boolean book(int start, int end) {
        if (segmentTree.query(1, 1, (int) 1e9, start + 1, end) >= 2) {
            return false;
        }

        segmentTree.update(1, 1, (int) 1e9, start + 1, end);

        return true;
    }

    // 动态开点，查询取最大值，如果查到的是 2 的话，那么说明会发生 3 重预定
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

        private void pushUp(int pos) {
            tree[pos].val = Math.max(tree[tree[pos].left].val, tree[tree[pos].right].val);
        }

        private void pushDown(int pos) {
            if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
                tree[tree[pos].left].val += tree[pos].add;
                tree[tree[pos].right].val += tree[pos].add;

                tree[tree[pos].left].add += tree[pos].add;
                tree[tree[pos].right].add += tree[pos].add;

                tree[pos].add = 0;
            }
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
    }
}

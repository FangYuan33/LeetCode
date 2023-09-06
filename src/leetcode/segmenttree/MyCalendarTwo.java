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
        if (segmentTree.query(1, 1, (int) 1e9 + 1, start + 1, end) >= 2) {
            return false;
        }
        segmentTree.update(1, 1, (int) 1e9 + 1, start + 1, end);

        return true;
    }

    static class SegmentTree {
        static class Node {
            int left;

            int right;

            int val;

            int add;
        }

        int count;

        Node[] tree;

        public SegmentTree() {
            count = 1;
            tree = new Node[(int) 5e6 + 1];
            tree[count++] = new Node();
        }

        public void update(int pos, int left, int right, int l, int r) {
            if (l <= left && right <= r) {
                tree[pos].val += 1;
                tree[pos].add += 1;
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

        public int query(int pos, int left, int right, int l, int r) {
            if (l <= left && right <= r) {
                return tree[pos].val;
            }

            lazyCreate(pos);

            pushDown(pos);

            int res = 0;
            int mid = left + right >> 1;
            if (l <= mid) {
                res = Math.max(query(tree[pos].left, left, mid, l, r), res);
            }
            if (r > mid){
                res = Math.max(query(tree[pos].right, mid + 1, right, l, r), res);
            }

            return res;
        }

        private void pushUp(int pos) {
            tree[pos].val = Math.max(tree[tree[pos].left].val, tree[tree[pos].right].val);
        }

        private void pushDown(int pos) {
            if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
                int add = tree[pos].add;

                tree[tree[pos].left].val += add;
                tree[tree[pos].left].add += add;
                tree[tree[pos].right].val += add;
                tree[tree[pos].right].add += add;

                tree[pos].add = 0;
            }
        }

        private void lazyCreate(int pos) {
            if (tree[pos] == null) {
                tree[pos] = new Node();
            }

            if (tree[pos].left == 0) {
                tree[pos].left = count++;
                tree[tree[pos].left] = new Node();
            }
            if (tree[pos].right == 0) {
                tree[pos].right = count++;
                tree[tree[pos].right] = new Node();
            }
        }
    }
}

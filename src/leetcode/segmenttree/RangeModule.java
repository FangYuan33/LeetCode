package leetcode.segmenttree;

public class RangeModule {

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();

        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        rangeModule.queryRange(10, 14);

        rangeModule.addRange(5, 7);
        rangeModule.queryRange(5, 7);

        rangeModule.addRange(6, 9);
        rangeModule.queryRange(5, 9);

        rangeModule.addRange(2, 7);
        rangeModule.queryRange(2, 9);

        rangeModule.removeRange(3, 10);
        rangeModule.queryRange(2, 9);

        rangeModule.removeRange(1, 8);
        rangeModule.queryRange(2, 9);

        rangeModule.removeRange(1, 10);
        rangeModule.queryRange(2, 9);

        System.out.println(rangeModule.queryRange(4, 7));
    }

    SegmentTree segmentTree;

    public RangeModule() {
        segmentTree = new SegmentTree();
    }

    public void addRange(int left, int right) {
        segmentTree.update(1, 1, (int) 1e9 + 1, left + 1, right, 1);
    }

    public boolean queryRange(int left, int right) {
        return segmentTree.queryResult(1, 1, (int) 1e9 + 1, left + 1, right);
    }

    public void removeRange(int left, int right) {
        segmentTree.update(1, 1, (int) 1e9 + 1, left + 1, right, -1);
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

        public boolean queryResult(int pos, int left, int right, int l, int r) {
            int res = query(pos, left, right, l, r);
            return res == r - l + 1;
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
                res += query(tree[pos].left, left, mid, l, r);
            }
            if (r > mid) {
                res += query(tree[pos].right, mid + 1, right, l, r);
            }

            return res;
        }

        public void update(int pos, int left, int right, int l, int r, int add) {
            if (l <= left && right <= r) {
                if (add == -1) {
                    tree[pos].val = 0;
                    tree[pos].add = -1;
                } else {
                    tree[pos].val = right - left + 1;
                    tree[pos].add = tree[pos].val;
                }
                return;
            }

            lazyCreate(pos);

            pushDown(pos);

            int mid = left + right >> 1;
            if (l <= mid) {
                update(tree[pos].left, left, mid, l, r, add);
            }
            if (r > mid) {
                update(tree[pos].right, mid + 1, right, l, r, add);
            }

            pushUp(pos);
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[tree[pos].left].val + tree[tree[pos].right].val;
        }

        private void pushDown(int pos) {
            if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
                int add = tree[pos].add;

                if (add == -1) {
                    tree[tree[pos].left].val = 0;
                    tree[tree[pos].left].add = -1;

                    tree[tree[pos].right].val = 0;
                    tree[tree[pos].right].add = -1;
                } else {
                    tree[tree[pos].left].val = add - add / 2;
                    tree[tree[pos].left].add = tree[tree[pos].left].val;

                    tree[tree[pos].right].val = add / 2;
                    tree[tree[pos].right].add = tree[tree[pos].right].val;
                }

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

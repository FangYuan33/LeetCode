package leetcode.segmenttree;

/**
 * 区间修改和区间查询，我们可以选择使用线段树来解题
 * 根据题意，我们需要满足动态开点
 */
public class RangeModule {

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();

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
        segmentTree.update(1, 1, (int) 1e9, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return segmentTree.query(1, 1, (int) 1e9, left, right - 1) == right - left;
    }

    public void removeRange(int left, int right) {
        segmentTree.update(1, 1, (int) 1e9, left, right - 1, -1);
    }

    static class SegmentTree {
        static class Node {
            int left;

            int right;

            // val 字段来表示被覆盖区间的长度
            int val;

            // add 字段表示当前区间的长度
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
                res += query(tree[pos].left, left, mid, l, r);
            }
            if (r > mid) {
                res += query(tree[pos].right, mid + 1, right, l, r);
            }

            return res;
        }

        public void update(int pos, int left, int right, int l, int r, int val) {
            if (l <= left && right <= r) {
                if (val == 1) {
                    tree[pos].val = right - left + 1;
                    tree[pos].add = right - left + 1;
                } else {
                    tree[pos].val = 0;
                    tree[pos].add = -(right - left + 1);
                }

                return;
            }

            lazyCreate(pos);

            pushDown(pos);

            int mid = left + right >> 1;
            if (l <= mid) {
                update(tree[pos].left, left, mid, l, r, val);
            }
            if (r > mid) {
                update(tree[pos].right, mid + 1, right, l, r, val);
            }

            pushUp(pos);
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[tree[pos].left].val + tree[tree[pos].right].val;
        }

        private void pushDown(int pos) {
            if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
                int add = tree[pos].add;

                if (add > 0) {
                    tree[tree[pos].left].val = add - add / 2;
                    tree[tree[pos].right].val = add / 2;
                } else {
                    tree[tree[pos].left].val = 0;
                    tree[tree[pos].right].val = 0;
                }
                tree[tree[pos].left].add = add - add / 2;
                tree[tree[pos].right].add = add / 2;

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

package leetcode.segmenttree;

public class SegmentTree3 {

    public static void main(String[] args) {
        SegmentTree3 segmentTree = new SegmentTree3();

        segmentTree.update(1, 1, 5, 5, 5, 14);
        segmentTree.update(1, 1, 5, 4, 4, 13);
        segmentTree.update(1, 1, 5, 3, 3, 12);
        segmentTree.update(1, 1, 5, 2, 2, 11);
        segmentTree.update(1, 1, 5, 1, 1, 10);

        System.out.println(segmentTree.query(1, 1, 5, 1, 5));
        System.out.println(segmentTree.query(1, 1, 5, 1, 1));
        System.out.println(segmentTree.query(1, 1, 5, 1, 2));
        System.out.println(segmentTree.query(1, 1, 5, 3, 5));
    }

    static class Node {

        // left 和 right 不再表示区间范围而是表示左右子节点在 tree 中的索引位置
        int left, right;

        int val;

        int add;
    }

    // 记录当前节点数
    int count;

    Node[] tree;

    public SegmentTree3() {
        count = 1;
        tree = new Node[(int) 5e6];
        tree[count] = new Node();
    }

    public int query(int pos, int left, int right, int l, int r) {
        if (l <= left && right <= r) {
            return tree[pos].val;
        }

        lazyCreate(pos);
        pushDown(pos, right - left + 1);

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

    /**
     * 修改区间的值
     *
     * @param pos   当前节点的索引值
     * @param left  当前线段树节点表示的范围下界
     * @param right 当前线段树节点表示的范围上界
     * @param l     要修改的区间下界
     * @param r     要修改的区间上界
     * @param val   区间值变化的大小
     */
    public void update(int pos, int left, int right, int l, int r, int val) {
        // 当前区间被要修改的区间全部包含
        if (l <= left && right <= r) {
            tree[pos].val += (right - left + 1) * val;
            tree[pos].add += val;
            return;
        }

        lazyCreate(pos);
        pushDown(pos, right - left + 1);

        int mid = left + right >> 1;
        if (l <= mid) {
            update(tree[pos].left, left, mid, l, r, val);
        }
        if (r > mid) {
            update(tree[pos].right, mid + 1, right, l, r, val);
        }
        pushUp(pos);
    }

    // 为该位置创建节点
    private void lazyCreate(int pos) {
        if (tree[pos] == null) {
            tree[pos] = new Node();
        }
        // 创建左子树节点
        if (tree[pos].left == 0) {
            tree[pos].left = ++count;
            tree[tree[pos].left] = new Node();
        }
        // 创建右子树节点
        if (tree[pos].right == 0) {
            tree[pos].right = ++count;
            tree[tree[pos].right] = new Node();
        }
    }

    private void pushDown(int pos, int len) {
        if (tree[pos].left != 0 && tree[pos].right != 0 && tree[pos].add != 0) {
            // 计算左右子树的值
            tree[tree[pos].left].val += (len - len / 2) * tree[pos].add;
            tree[tree[pos].right].val += len / 2 * tree[pos].add;

            // 子节点懒惰标记
            tree[tree[pos].left].add += tree[pos].add;
            tree[tree[pos].right].add += tree[pos].add;

            tree[pos].add = 0;
        }
    }

    private void pushUp(int pos) {
        tree[pos].val = tree[tree[pos].left].val + tree[tree[pos].right].val;
    }
}

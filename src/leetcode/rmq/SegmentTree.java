package leetcode.rmq;

/**
 * 线段树
 */
public class SegmentTree {

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{10, 11, 12, 13, 14});

//        segmentTree.update(1, 3, 11);
        System.out.println(segmentTree.query(1, 1, 4));
    }

    /**
     * 定义线段树节点
     */
    static class Node {
        /**
         * 区间和 或 区间最大/最小值
         */
        int val;

        int left;

        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    Node[] tree;

    int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new Node[nums.length * 4];
        // 建树，注意表示区间时使用的是从 1 开始的索引值
        build(1, 1, nums.length);
    }

    /**
     * 建树
     *
     * @param pos   当前节点编号
     * @param left  当前节点区间左值
     * @param right 当前节点区间右值
     */
    private void build(int pos, int left, int right) {
        // 创建节点
        tree[pos] = new Node(left, right);
        // 递归结束条件
        if (left == right) {
            // 赋值
            tree[pos].val = nums[left - 1];
            return;
        }

        // 如果没有到根节点，则继续递归
        int mid = left + right >> 1;
        build(pos << 1, left, mid);
        build(pos << 1 | 1, mid + 1, right);

        // 当前节点的值是左子树和右子树节点的和
        pushUp(pos);
    }

    /**
     * 修改单节点的值
     *
     * @param pos    当前节点编号
     * @param numPos 需要修改的区间中值的位置
     * @param val    修改后的值
     */
    private void update(int pos, int numPos, int val) {
        // 找到该数值所在线段树种的叶子节点
        if (tree[pos].left == numPos && tree[pos].right == numPos) {
            tree[pos].val = val;
            return;
        }
        // 如果不是当前节点那么需要判断是去左或右去找
        int mid = tree[pos].left + tree[pos].right >> 1;
        if (numPos <= mid) {
            update(pos << 1, numPos, val);
        } else {
            update(pos << 1 | 1, numPos, val);
        }

        // 叶子节点的值修改完了，需要回溯更新所有相关父节点的值
        pushUp(pos);
    }

    /**
     * 用于向上回溯时修改父节点的值
     */
    private void pushUp(int pos) {
        tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
    }

    /**
     * 查找对应区间的值
     *
     * @param pos   当前节点
     * @param left  要查询的区间的左值
     * @param right 要查询的区间的右值
     */
    private int query(int pos, int left, int right) {
        // 如果当前节点是我们想要的区间值
        if (tree[pos].left == left && tree[pos].right == right) {
            return tree[pos].val;
        }

        // 如果不是的话，则需要根据情况再去找
        int mid = tree[pos].left + tree[pos].right >> 1;
        // 如果想要找的区间值全在左边
        if (right <= mid) {
            return query(pos << 1, left, right);
        } else if (left > mid) {
            // 如果区间值全在右边
            return query(pos << 1 | 1, left, right);
        } else {
            // 左右两边都有的话，需要两边一起找
            return query(pos << 1, left, mid) + query(pos << 1 | 1, mid + 1, right);
        }
    }
}

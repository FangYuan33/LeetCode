package leetcode.segmenttree;

public class SegmentTree2 {

    public static void main(String[] args) {
        SegmentTree2 segmentTree = new SegmentTree2(new int[]{10, 11, 12, 13, 14});

        System.out.println(segmentTree.query(1, 1, 5));
        segmentTree.update(1, 1, 5, 1);
        System.out.println(segmentTree.query(1, 1, 5));
        System.out.println(segmentTree.query(1, 1, 1));
    }

    class Node {
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

    int[] nums;

    public SegmentTree2(int[] nums) {
        this.tree = new Node[nums.length * 4];
        this.nums = nums;

        build(1, 1, nums.length);
    }

    private void build(int pos, int left, int right) {
        tree[pos] = new Node(left, right);
        // 递归结束条件
        if (left == right) {
            tree[pos].val = nums[left - 1];
            return;
        }

        int mid = left + right >> 1;
        build(pos << 1, left, mid);
        build(pos << 1 | 1, mid + 1, right);

        // 回溯修改父节点的值
        pushUp(pos);
    }

    private void pushUp(int pos) {
        tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
    }

    /**
     * 修改区间的值
     *
     * @param pos   当前节点编号
     * @param left  要修改区间的下界
     * @param right 要修改区间的上界
     * @param val   区间内每个值的变化量
     */
    public void update(int pos, int left, int right, int val) {
        // 如果该区间被要修改的区间包围的话，那么需要将该区间所有的值都修改
        if (left <= tree[pos].left && tree[pos].right <= right) {
            tree[pos].val += (tree[pos].right - tree[pos].left + 1) * val;
            // 懒惰标记
            tree[pos].add += val;
        } else {
            // 该区间没有被包围的话，需要修改节点的信息
            pushDown(pos);

            int mid = tree[pos].left + tree[pos].right >> 1;
            // 如果下界在 mid 左边，那么左子树需要修改
            if (left <= mid) {
                update(pos << 1, left, mid, val);
            }
            // 如果上界在 mid 右边，那么右子树也需要修改
            if (right > mid) {
                update(pos << 1 | 1, mid + 1, right, val);
            }
            // 修改完成后向上回溯修改父节点的值
            pushUp(pos);
        }
    }

    public int query(int pos, int left, int right) {
        if (left <= tree[pos].left && tree[pos].right <= right) {
            // 当前区间被包围
            return tree[pos].val;
        } else {
            // 懒惰标记需要下传修改子节点的值
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
    }

    private void pushDown(int pos) {
        // 根节点和为 0 的情况不需要再向下遍历
        if (tree[pos].left != tree[pos].right && tree[pos].add != 0) {
            int mid = tree[pos].left + tree[pos].right >> 1;
            int add = tree[pos].add;
            // 计算累加变化量
            tree[pos << 1].val += add * (mid - tree[pos].left + 1);
            tree[pos << 1 | 1].val += add * (tree[pos].right - mid);

            // 子节点懒惰标记
            tree[pos << 1].add += add;
            tree[pos << 1 | 1].add += add;

            // 懒惰标记清 0
            tree[pos].add = 0;
        }
    }
}


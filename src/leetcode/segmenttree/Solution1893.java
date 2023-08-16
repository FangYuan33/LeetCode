package leetcode.segmenttree;

public class Solution1893 {

    public static void main(String[] args) {
//        new Solution1893().isCovered(new int[][]{new int[]{1, 2}, new int[] {3, 4}, new int[] {5, 6}}, 2, 5);
        new Solution1893().isCovered(new int[][]{new int[]{1, 50}}, 1, 50);
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        SegmentTree segmentTree = new SegmentTree();
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                segmentTree.update(1, i, 1);
            }
        }

        return segmentTree.query(1, left, right) == right - left + 1;
    }

    static class SegmentTree {
        static class Node {
            int left;

            int right;

            int val;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        Node[] tree;

        public SegmentTree() {
            tree = new Node[200];
            build(1, 1, 50);
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

        public void update(int pos, int index, int val) {
            if (tree[pos].left == index && tree[pos].right == index) {
                tree[pos].val = val;
                return;
            }

            // 左右去找对应的节点
            int mid = tree[pos].left + tree[pos].right >> 1;
            if (index <= mid) {
                update(pos << 1, index, val);
            } else {
                update(pos << 1 | 1, index, val);
            }

            pushUp(pos);
        }

        public int query(int pos, int left, int right) {
            if (tree[pos].left == left && tree[pos].right == right) {
                return tree[pos].val;
            }

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (right <= mid) {
                // 全去左边找
                return query(pos << 1, left, right);
            } else if (left > mid) {
                // 全去右边找
                return query(pos << 1 | 1, left, right);
            } else {
                return query(pos << 1, left, mid) + query(pos << 1 | 1, mid + 1, right);
            }
        }

        private void pushUp(int pos) {
            tree[pos].val = tree[pos << 1].val + tree[pos << 1 | 1].val;
        }
    }
}

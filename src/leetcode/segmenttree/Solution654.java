package leetcode.segmenttree;

import leetcode.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        SegmentTree segmentTree = new SegmentTree(nums);

        return recursion(1, nums.length, segmentTree);
    }

    private TreeNode recursion(int left, int right, SegmentTree segmentTree) {
        // 递归结束条件
        if (left > right) {
            return null;
        }

        SegmentTree.Node node = segmentTree.query(1, left, right);

        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = recursion(left, node.index - 1, segmentTree);
        treeNode.right = recursion(node.index + 1, right, segmentTree);

        return treeNode;
    }

    static class SegmentTree {
        static class Node {
            int val;

            int index;

            int left;

            int right;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        private int[] nums;

        private Node[] tree;

        public SegmentTree(int[] nums) {
            this.nums = nums;
            tree = new Node[nums.length * 4];
            // 构建树
            build(1, 1, nums.length);
        }

        private void build(int pos, int left, int right) {
            tree[pos] = new Node(left, right);
            if (left == right) {
                tree[pos].val = nums[left - 1];
                // 维护当前节点的索引值
                tree[pos].index = left;
                return;
            }

            int mid = left + right >> 1;
            build(pos << 1, left, mid);
            build(pos << 1 | 1, mid + 1, right);

            pushUp(pos);
        }

        private void pushUp(int pos) {
            Node max;
            if (tree[pos << 1].val < tree[pos << 1 | 1].val) {
                max = tree[pos << 1 | 1];
            } else {
                max = tree[pos << 1];
            }

            tree[pos].val = max.val;
            tree[pos].index = max.index;
        }

        public Node query(int pos, int left, int right) {
            if (tree[pos].left == left && tree[pos].right == right) {
                return tree[pos];
            }

            int mid = tree[pos].left + tree[pos].right >> 1;
            if (right <= mid) {
                return query(pos << 1, left, right);
            } else if (left > mid) {
                return query(pos << 1 | 1, left, right);
            } else {
                Node x = query(pos << 1, left, mid);
                Node y = query(pos << 1 | 1, mid + 1, right);

                if (x.val > y.val) {
                    return x;
                } else {
                    return y;
                }
            }
        }
    }
}

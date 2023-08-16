package leetcode.binaryindexedtree;

public class Solution1893 {

    public static void main(String[] args) {
//        new Solution1893().isCovered(new int[][]{new int[]{1, 2}, new int[] {3, 4}, new int[] {5, 6}}, 2, 5);
        new Solution1893().isCovered(new int[][]{new int[]{1, 50}}, 1, 50);
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        BinaryIndexTree binaryIndexTree = new BinaryIndexTree();

        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                binaryIndexTree.update(i);
            }
        }

        // 挨个数字找是否出现过
        for (int i = left; i <= right; i++) {
            int count = binaryIndexTree.query(i) - binaryIndexTree.query(i - 1);
            if (count == 0) {
                return false;
            }
        }

        return true;
    }

    static class BinaryIndexTree {

        // 用来标记对应数字是否出现
        int[] tree;

        public BinaryIndexTree() {
            this.tree = new int[51];
        }

        public void update(int num) {
            for (int i = num; i < tree.length; i += lowbit(i)) {
                tree[i] += 1;
            }
        }

        private int query(int right) {
            int res = 0;

            for (int i = right; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

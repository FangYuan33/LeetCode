package leetcode.binaryindexedtree;

public class NumArray {

    public static void main(String[] args) {
        System.out.println(new NumArray(new int[]{1, 3, 5}).sumRange(0, 2));
    }

    BinaryIndexedTree binaryIndexedTree;

    public NumArray(int[] nums) {
        binaryIndexedTree = new BinaryIndexedTree(nums);
    }

    public void update(int index, int val) {
        binaryIndexedTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return binaryIndexedTree.sumRange(left, right);
    }

    static class BinaryIndexedTree {

        int[] a;

        int[] c;

        public BinaryIndexedTree(int[] a) {
            this.a = a;
            c = new int[a.length + 1];

            for (int i = 0; i < a.length; i++) {
                add(i + 1, a[i]);
            }
        }

        public void update(int index, int val) {
            int num = val - a[index];
            a[index] = val;

            add(index + 1, num);
        }

        private void add(int index, int val) {
            for (int i = index; i < c.length; i += lowbit(i)) {
                c[i] += val;
            }
        }

        public int sumRange(int left, int right) {
            return sum(right + 1) - sum(left);
        }

        private int sum(int n) {
            int res = 0;
            for (int i = n; i > 0; i -= lowbit(i)) {
                res += c[i];
            }

            return res;
        }

        private int lowbit(int x) {
            return x & -x;
        }
    }
}

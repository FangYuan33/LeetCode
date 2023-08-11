package leetcode.binaryindexedtree;

public class BinaryIndexedTree {

    public static void main(String[] args) {
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(binaryIndexedTree.query(3, 6));
    }

    int[] a;

    int[] c;

    public BinaryIndexedTree(int[] a) {
        this.a = a;
        this.c = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            add(i + 1, a[i]);
        }
    }

    // 将 index 索引处的值更新为 num
    void update(int index, int num) {
        a[index] = num;
        add(index, num - a[index]);
    }

    // 更新 c[index] 的值，变化差值为 val
    void add(int index, int val) {
        for (int i = index; i < c.length; i += lowbit(i)) {
            c[i] += val;
        }
    }

    int query(int left, int right) {
        return query(right) - query(left - 1);
    }

    // 查询前缀和的方法
    int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += c[i];
        }

        return res;
    }

    int lowbit(int x) {
        return x & -x;
    }
}

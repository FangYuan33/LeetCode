package leetcode.uf;

/**
 * 加权 quick-union 算法
 *
 * @author wangyilong13
 * @since 2023-08-20 16:18:13
 */
public class WeightedQuickUnionUF {

    // 记录当前索引位置的父索引，当索引值与值相同时，则到达了根节点
    private int[] id;

    // 树的大小
    private int[] sz;

    // 联通分量的数量
    private int n;

    // 初始化时每个节点只与自己是联通的
    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        sz = new int[n];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = i;
        }
        this.n = n;
    }

    public int count() {
        return n;
    }

    // 判断 p q 是否联通
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 联通 p 和 q
    public void union(int p, int q) {
        int pVal = find(p);
        int qVal = find(q);

        // 已经联通
        if (pVal == qVal) {
            return;
        }

        if (sz[pVal] < sz[qVal]) { // 将小的连接到大的上
            id[pVal] = qVal;
            sz[qVal] += sz[pVal];
        } else {
            id[qVal] = pVal;
            sz[pVal] += sz[qVal];
        }
        n--;
    }

    // 找到根节点
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }
}

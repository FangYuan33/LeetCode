package leetcode.binaryindexedtree;

import java.util.*;

public class Solution327 {

    public static void main(String[] args) {
        System.out.println(new Solution327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 使用 set 记录下所有的前缀和前缀和需要满足的题意范围的值，供我们做离散化使用，之所以使用 set 是因为我们只需要知道它在树状数组中的位置，而不要求它的数量
        Set<Long> set = new HashSet<>();
        long preSum = 0L;
        // 需要将前缀和 0 也标记进来，它是原数组索引 0 处值的前缀和
        set.add(preSum);
        for (int j : nums) {
            preSum += j;

            set.add(preSum);
            set.add(preSum - upper);
            set.add(preSum - lower);
        }
        // 所有的值都有了，我们进行离散化处理
        ArrayList<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        // 使用 hashmap 来保存值对应在树状数组的索引
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }

        int res = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree();
        // 前缀和从 0 开始计算
        preSum = 0L;
        // 标记数组索引 0 前的前缀和在树状数组中的位置
        tree.update(map.get(0L));

        for (int num : nums) {
            preSum += num;

            int left = map.get(preSum - upper);
            int right = map.get(preSum - lower);
            res += tree.query(left, right);

            // 更新该前缀和在树状数组中的位置
            tree.update(map.get(preSum));
        }

        return res;
    }

    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            // 数组长度为 1e5 我们需要把对应的范围值也保存上，所以需要 * 3
            tree = new int[(int) 3e5 + 1];
        }

        public void update(int index) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += 1;
            }
        }

        public int query(int left, int right) {
            return query(right) - query(left - 1);
        }

        public int query(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

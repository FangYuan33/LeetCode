package leetcode.binaryindexedtree;

import java.util.*;

public class Solution327 {

    public static void main(String[] args) {
        System.out.println(new Solution327().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 先计算前缀和
        long preSum = 0L;
        Set<Long> allSum = new HashSet<>();
        // 无元素的前缀和时为 0，需要添加进来
        allSum.add(0L);
        for (int num : nums) {
            preSum += num;

            allSum.add(preSum);
            // 区间范围也需要
            allSum.add(preSum - upper);
            allSum.add(preSum - lower);
        }

        // 由于区间和值域爆炸，我们需要对它进行离散化处理
        ArrayList<Long> list = new ArrayList<>(allSum);
        Collections.sort(list);
        // 将对应的值映射为树状数组的索引上
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }

        int res = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree();
        // 标记上第一个元素前缀和前边的占位 0
        preSum = 0L;
        tree.update(map.get(preSum));

        for (int num : nums) {
            preSum += num;

            // 由当前前缀和的后一个前缀和计算出区间范围
            Integer left = map.get(preSum - upper);
            Integer right = map.get(preSum - lower);
            // 计算结果
            res += tree.query(left, right);

            // 更新上当前前缀和
            tree.update(map.get(preSum));
        }

        return res;
    }

    // 单点更新和区间查询
    static class BinaryIndexedTree {

        int[] tree;

        public BinaryIndexedTree() {
            tree = new int[(int) 3e5 + 1];
        }

        public int query(int left, int right) {
            return query(right) - query(left - 1);
        }

        public int query(int x) {
            int res = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }

            return res;
        }

        public void update(int index) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += 1;
            }
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}

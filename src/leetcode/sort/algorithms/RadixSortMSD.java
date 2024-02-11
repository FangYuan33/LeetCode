package leetcode.sort.algorithms;

import java.util.*;

/**
 * 高位优先（MSD）基数排序-递归法实现
 * 在小数据范围下结合使用了插入排序
 *
 * @author FangYuan
 * @since 2024-02-11 11:26:37
 */
public class RadixSortMSD {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(111, 110, 100, 12, 11);
        new RadixSortMSD().sort(list);
        System.out.println(list);
    }

    private void sort(List<Integer> nums) {
        if (nums.size() <= 1) {
            return;
        }

        // 1. 创建桶
        Queue<Integer>[] buckets = createBuckets();
        // 2. 获取执行轮次
        int radixRounds = getRadixRounds(nums);

        for (int i = 0; i < radixRounds; i++) {
            for (Integer num : nums) {
                if (i >= String.valueOf(num).length()) {
                    buckets[0].offer(num);
                } else {
                    buckets[String.valueOf(num).charAt(i) - 47].offer(num);
                }
            }

            int numIndex = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    nums.set(numIndex++, bucket.poll());
                }
            }
        }
    }

    /**
     * 虽然整数的的取值范围是 0 - 9，但是需要创建 11 个桶
     * 多出来的一个桶用来放那些超过位数的数字
     */
    @SuppressWarnings("unchecked")
    private Queue<Integer>[] createBuckets() {
        Queue<Integer>[] buckets = new Queue[11];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        return buckets;
    }

    /**
     * 获取基数排序的执行轮次
     */
    private int getRadixRounds(List<Integer> nums) {
        return String.valueOf(nums.stream().max(Integer::compareTo).get()).length();
    }
}

package leetcode.sort.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基数排序
 *
 * @author FangYuan
 * @since 2023-11-17 15:40:29
 */
public class RadixSort {

    public static void main(String[] args) {
        new RadixSort().sort(new int[]{3, 100, 11, 4, 33});
    }

    private void sort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 1. 整数的每位取值范围为 0-9，因此需要创建10个桶
        Queue<Integer>[] buckets = createBuckets();

        // 2. 获取基数排序的执行轮次
        int radixRounds = getRadixRounds(nums);

        // 3. 根据执行轮次处理各个"位"，eg: 第一轮处理个位...
        for (int round = 1; round <= radixRounds; round++) {
            for (int num : nums) {
                // 获取所在桶的索引
                int bucketIndex = getBucketIndex(num, round);
                // 进桶
                buckets[bucketIndex].offer(num);
            }

            // 出桶赋值，当前结果为根据当前位排序的结果
            int numsIndex = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    nums[numsIndex++] = bucket.poll();
                }
            }
        }
    }

    /**
     * 创建大小为10的数组作为桶，每个桶都是一个队列
     */
    @SuppressWarnings("unchecked")
    private Queue<Integer>[] createBuckets() {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        return buckets;
    }

    /**
     * 获取基数排序的执行轮次
     */
    private int getRadixRounds(int[] nums) {
        return String.valueOf(Arrays.stream(nums).max().getAsInt()).length();
    }

    /**
     * 获取该数所在桶的索引
     */
    private int getBucketIndex(int num, int round) {
        int bucketIndex = 0;

        while (round != 0) {
            bucketIndex = num % 10;
            num /= 10;

            round--;
        }

        return bucketIndex;
    }
}

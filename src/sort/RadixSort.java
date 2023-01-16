package sort;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

    public static void main(String[] args) {
        int[] nums = {23, 12, 3, 4, 788, 170};

        radixSort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void radixSort(int[] nums) {
        // 1. 获取基数排序执行的轮次
        int rounds = getRadixRounds(nums);

        // 2. 创建桶，每个桶都是一个队列
        Queue<Integer>[] buckets = createBuckets();

        // 3. 执行分桶、重新赋值数组
        for (int round = 1; round <= rounds; round++) {
            // 3.1 分桶
            for (int num : nums) {
                // 获取该数值在某桶的索引值
                int bucketIndex = getIndex(num, round);
                // 向该桶中添加该数值
                buckets[bucketIndex].offer(num);
            }

            // 3.2 遍历桶，重新向数组中赋值
            int index = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty())
                    nums[index++] = bucket.poll();
            }
        }
    }

    /**
     * 获取基数排序执行的轮次，即最大数值的位数
     */
    private static int getRadixRounds(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        return String.valueOf(max).length();
    }

    /**
     * 创建桶，即为0-9
     */
    private static Queue<Integer>[] createBuckets() {
        Queue<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        return buckets;
    }

    /**
     * 获取该数值在桶位置中的索引
     * 当该数值位数小于当前轮次时，计算结果为0，都会被排在第一个桶中
     */
    private static int getIndex(int num, int round) {
        int ret = 0;
        for (int i = 1; i <= round; i++) {
            ret = num % 10;
            num /= 10;
        }

        return ret;
    }
}

package leetcode.sort.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 桶排序
 *
 * @author FangYuan
 * @since 2023-11-17 14:03:36
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] nums = new int[50];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i - 1;
        }

        new BucketSort().sort(nums);
    }

    /**
     * 桶排序：指定数据范围为0 - 49，分桶为5个，每10个数为一个桶
     */
    public void sort(int[] nums) {
        // 声明5个桶
        List<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            buckets.add(new ArrayList<>());
        }

        // 数组元素分桶
        intoBucket(buckets, nums);

        // 出桶
        outOfBucket(buckets, nums);
    }

    /**
     * 分桶
     */
    private void intoBucket(List<ArrayList<Integer>> buckets, int[] nums) {
        for (int num : nums) {
            int bucketIndex = num / 10;
            buckets.get(bucketIndex).add(num);
        }
    }

    /**
     * 出桶
     */
    private void outOfBucket(List<ArrayList<Integer>> buckets, int[] nums) {
        // 出桶覆盖原数组值
        int numsIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            // 先排序 再出桶
            bucket.sort(Comparator.comparingInt(x -> x));

            for (Integer num : bucket) {
                nums[numsIndex++] = num;
            }
        }
    }
}

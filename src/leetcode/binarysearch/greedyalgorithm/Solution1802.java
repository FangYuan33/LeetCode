package leetcode.binarysearch.greedyalgorithm;

public class Solution1802 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution1802().maxValue(4, 0, 6));
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum + 1;
        while (left < right) {
            int mid = left + right >> 1;

            long sum = getSum(mid, index + 1);
            sum += getSum(mid - 1, n - index - 1);

            if (sum > maxSum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    /**
     * 求和
     *
     * @param last   尾项
     * @param length 长度
     */
    private long getSum(int last, int length) {
        long sum = 0L;
        if (last > length) {
            sum += (long) (last - length + 1 + last) * length / 2;
        } else {
            sum += (long) (1 + last) * last / 2;
            sum += length - last;
        }

        return sum;
    }
}

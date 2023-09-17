package leetcode.binarysearch.greedyalgorithm;

public class Solution1802 {

    public static void main(String[] args) {
        System.out.println(new Solution1802().maxValue(4, 0, 6));
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum + 1;
        while (left < right) {
            int mid = left + right >> 1;

            long sum = 0L;
            sum += sum(mid, index + 1);
            sum += sum(mid - 1, n - index - 1);

            if (sum <= maxSum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    /**
     * 求和
     *
     * @param last 最后一项的值
     * @param m    总的长度
     */
    private long sum(int last, int m) {
        long sum = 0L;
        if (m < last) {
            sum += (long) (last + last - m + 1) * m / 2;
        } else {
            sum += (long) (1 + last) * last / 2;
            sum += (m - last);
        }

        return sum;
    }
}

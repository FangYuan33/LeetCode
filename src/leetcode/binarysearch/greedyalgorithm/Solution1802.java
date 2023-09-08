package leetcode.binarysearch.greedyalgorithm;

public class Solution1802 {

    public static void main(String[] args) {
        System.out.println(new Solution1802().maxValue(4, 0, 6));
    }
    // 4321

    public int maxValue(int n, int index, int maxSum) {
        long left = 1, right = maxSum + 1;
        while (left < right) {
            long mid = left + right >> 1;

            long sum = mid;
            if (index > mid - 1) {
                long an = mid - 1, a1 = 1, cnt = mid - 1;
                sum += cnt * (a1 + an) / 2;
                sum += index - cnt;
            } else {
                long cnt = index, an = mid - 1, a1 = an - cnt + 1;
                sum += cnt * (a1 + an) / 2;
            }
            if (n - index - 1 > mid - 1) {
                long an = mid - 1, a1 = 1, cnt = mid - 1;
                sum += cnt * (a1 + an) / 2;
                sum += n - index - 1 - cnt;
            } else {
                long cnt = n - index - 1, an = mid - 1, a1 = an - cnt + 1;
                sum += cnt * (a1 + an) / 2;
            }

            if (sum > maxSum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left - 1;
    }
}

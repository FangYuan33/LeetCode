package leetcode.binarysearch.greedyalgorithm;

public class Solution668 {

    public static void main(String[] args) {
        System.out.println(new Solution668().findKthNumber(3, 3, 5));
    }
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + right >> 1;

            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(n, mid / i);
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}

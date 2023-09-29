package leetcode.binarysearch.greedyalgorithm;

public class Solution1011 {

    public static void main(String[] args) {
        // 15
        System.out.println(new Solution1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + right >> 1;

            int already = 0;
            int day = 1;
            for (int weight : weights) {
                if (already + weight <= mid) {
                    already += weight;
                } else {
                    day++;
                    already = weight;
                }
            }

            if (day > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

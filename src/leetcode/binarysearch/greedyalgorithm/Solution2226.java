package leetcode.binarysearch.greedyalgorithm;

public class Solution2226 {

    public static void main(String[] args) {
        System.out.println(new Solution2226().maximumCandies(new int[]{5, 8, 6}, 3));
    }

    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0;
        for (int candy : candies) {
            right = Math.max(right, candy);
        }
        right++;

        while (left < right) {
            int mid = left + right >> 1;

            long temp = 0;
            for (int candy : candies) {
                temp += candy / mid;
            }

            if (temp < k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left == candies.length ? 0 : left - 1;
    }
}

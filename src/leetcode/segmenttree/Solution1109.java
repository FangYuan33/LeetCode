package leetcode.segmenttree;

public class Solution1109 {

    public static void main(String[] args) {
        new Solution1109().corpFlightBookings(new int[][]{new int[]{1, 2, 10}, new int[]{2, 3, 20}, new int[]{2, 5, 25}}, 5);
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int left = booking[0], right = booking[1];
            int val = booking[2];

            for (int i = left; i <= right; i++) {
                res[i - 1] += val;
            }
        }

        return res;
    }

}

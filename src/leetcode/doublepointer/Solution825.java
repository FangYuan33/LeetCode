package leetcode.doublepointer;

import java.util.Arrays;

public class Solution825 {

    public static void main(String[] args) {
        System.out.println(new Solution825().numFriendRequests(new int[]{16, 17, 18}));
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;

        int left = 0, right = 0;
        for (int i = 0; i < ages.length; i++) {
            while (left < i && noSend(ages[left], ages[i])) {
                left++;
            }

            if (right < i) {
                right = i;
            }
            while (right < ages.length && !noSend(ages[right], ages[i])) {
                right++;
            }

            if (right > left) {
                res += right - left - 1;
            }
        }

        return res;
    }

    private boolean noSend(int x, int y) {
        return y <= 0.5 * x + 7 || y > x || (y > 100 && x < 100);
    }
}

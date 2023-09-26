package leetcode.doublepointer;

import java.util.Arrays;

public class Solution825 {

    public static void main(String[] args) {
        System.out.println(new Solution825().numFriendRequests(new int[]{108, 115, 5, 24, 82}));
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        int left = 0, right = 0;
        for (int i = 0; i < ages.length; i++) {
            // 确定自己给别人发的和别人给自己发的范围
            while (noSend(ages[left], ages[i]) && left < i) {
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

    public boolean noSend(int x, int y) {
        return y <= 0.5 * x + 7 || y > x;
    }
}

package leetcode.doublepointer;

public class Solution481 {
    public int magicalString(int n) {
        // 1221121221221121122...
        if (n <= 3) {
            return 1;
        }

        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;

        boolean isOne = true;
        int num;
        int left = 2, right = 3;
        while (right < n) {
            if (isOne) {
                num = 1;
            } else {
                num = 2;
            }

            nums[right++] = num;
            if (nums[left] == 2) {
                nums[right++] = num;
            }

            left++;
            isOne = !isOne;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                res++;
            }
        }

        return res;
    }
}

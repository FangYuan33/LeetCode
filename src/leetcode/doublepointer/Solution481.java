package leetcode.doublepointer;

public class Solution481 {


    public int magicalString(int n) {
        // 1221121221221121122...
        if (n <= 3) {
            return 1;
        }

        int res = 1;
        boolean one = true;
        int index = 2, numIndex = 3;
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        while (numIndex < n) {
            if (one) {
                nums[numIndex++] = 1;
                res++;
                if (nums[index] == 2 && numIndex < n) {
                    nums[numIndex++] = 1;
                    res++;
                }
            } else {
                nums[numIndex++] = 2;
                if (nums[index] == 2) {
                    nums[numIndex++] = 2;
                }
            }
            one = !one;
        }

        return res;
    }
}

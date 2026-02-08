package dp;

public class Solution152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, curMax = 1, curMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);

            max = Math.max(max, curMax);
        }

        return max;
    }

}

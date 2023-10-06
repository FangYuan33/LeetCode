package leetcode.doublepointer;

public class Solution481 {

    public static void main(String[] args) {
        System.out.println(new Solution481().magicalString(7));
    }

    public int magicalString(int n) {
        // 122 112 1 221221121122...
        if (n <= 3) {
            return 1;
        }

        int index = 2;
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int num = 1;
        for (int i = 3; i < n;) {
            nums[i++] = num;
            if (nums[index] == 2) {
                nums[i++] = num;
            }
            if (num == 1) {
                num = 2;
            } else {
                num = 1;
            }
            index++;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i] == 1 ? 1 : 0;
        }

        return res;
    }
}

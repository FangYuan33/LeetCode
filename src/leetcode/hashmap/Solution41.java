package leetcode.hashmap;

public class Solution41 {

    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] - 1 != i && (nums[i] - 1) < nums.length && (nums[i] - 1) >= 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int res = 1;
        for (int num : nums) {
            if (num == res) {
                res++;
            }
        }

        return res;
    }
}

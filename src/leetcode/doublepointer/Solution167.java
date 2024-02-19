package leetcode.doublepointer;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}

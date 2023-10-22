package leetcode.doublepointer;

public class SolutionLCR139 {
    public int[] trainingPlan(int[] actions) {
        int left = 0, right = actions.length - 1;

        while (left < right) {
            while (left < right && actions[left] % 2 == 1) {
                left++;
            }
            while (left < right && actions[right] % 2 == 0) {
                right--;
            }

            swap(actions, left, right);
        }

        return actions;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

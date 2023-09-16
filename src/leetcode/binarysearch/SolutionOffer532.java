package leetcode.binarysearch;

public class SolutionOffer532 {

    public static void main(String[] args) {
        System.out.println(new SolutionOffer532().missingNumber(new int[]{0, 2, 3}));
    }

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] != mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

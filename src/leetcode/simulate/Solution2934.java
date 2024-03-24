package leetcode.simulate;

public class Solution2934 {

    public static void main(String[] args) {
        System.out.println(new Solution2934().minOperations(new int[]{1, 5, 15}, new int[]{1, 1, 1}));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int res = Math.min(operate(nums1[n - 1], nums2[n - 1], nums1, nums2),
                1 + operate(nums2[n - 1], nums1[n - 1], nums1, nums2));
        return res > n ? -1 : res;
    }

    private int operate(int max1, int max2, int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length - 1; i++) {
            if (nums1[i] > max1 || nums2[i] > max2) {
                if (nums1[i] > max2 || nums2[i] > max1) {
                    return nums1.length + 1;
                }
                res++;
            }
        }

        return res;
    }
}

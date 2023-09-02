package leetcode.simulate;

import java.util.Arrays;

public class Solution496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    j++;
                    while (j < nums2.length) {
                        if (nums2[j] > nums1[i]) {
                            res[i] = nums2[j];
                            break;
                        }
                        j++;
                    }
                }
            }
        }

        return res;
    }
}

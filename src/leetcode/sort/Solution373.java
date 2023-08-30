package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution373 {

    public static void main(String[] args) {
        new Solution373().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 从 nums2 中找到 nums[i] 开始的比它大的位置，然后不断的往里边放，不断的重复这个过程
        List<List<Integer>> res = new ArrayList<>();
        int[] numIndex = new int[nums1.length];

        while (res.size() < k) {
            for (int i = 0; i < nums1.length; i++) {
                int left = numIndex[i], right = nums2.length;
                while (left <= right) {
                    int mid = left + right >> 1;

                    if (nums1[i] > nums2[mid]) {
                        left = mid + 1;
                    } else if (nums1[i] < nums2[mid]) {
                        right = mid - 1;
                    } else {
                        break;
                    }
                }
                numIndex[i] = left == 0 ? 0 : left + 1;

                for (int j = 0; j < numIndex[i]; j++) {
                    res.add(Arrays.asList(nums1[i], nums2[j]));
                    if (res.size() == k) {
                        break;
                    }
                }
                if (res.size() == k) {
                    break;
                }
            }
        }

        return res;
    }
}

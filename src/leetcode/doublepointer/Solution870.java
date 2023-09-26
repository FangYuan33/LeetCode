package leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution870 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution870().advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        HashMap<Integer, LinkedList<Integer>> numIndex = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            LinkedList<Integer> index = numIndex.getOrDefault(nums2[i], new LinkedList<>());
            index.add(i);
            numIndex.put(nums2[i], index);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = 0;
        int left = 0, right = nums2.length - 1;
        int[] res = new int[nums1.length];
        while (left <= right) {
            if (nums1[n] > nums2[left]) {
                res[numIndex.get(nums2[left++]).pollFirst()] = nums1[n];
            } else {
                res[numIndex.get(nums2[right--]).pollFirst()] = nums1[n];
            }
            n++;
        }

        return res;
    }
}

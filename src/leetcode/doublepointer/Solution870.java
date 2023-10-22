package leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution870 {

    public static void main(String[] args) {
        // [2, 0, 2, 1, 4]
        System.out.println(Arrays.toString(new Solution870().advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        HashMap<Integer, LinkedList<Integer>> num2Index = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            LinkedList<Integer> linkedList = num2Index.getOrDefault(nums2[i], new LinkedList<>());
            linkedList.add(i);
            num2Index.put(nums2[i], linkedList);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int n = 0;
        int left = 0, right = nums2.length - 1;
        while (left <= right) {
            if (nums1[n] > nums2[left]) {
                res[num2Index.get(nums2[left++]).pollLast()] = nums1[n++];
            } else {
                res[num2Index.get(nums2[right--]).pollLast()] = nums1[n++];
            }
        }

        return res;
    }
}

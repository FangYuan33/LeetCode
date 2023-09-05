package leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution870 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution870().advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            LinkedList<Integer> list = map.getOrDefault(nums2[i], new LinkedList<>());
            list.add(i);
            map.put(nums2[i], list);
        }
        Arrays.sort(nums2);

        int[] res = new int[nums2.length];
        int n1 = 0;
        int n2 = 0, n3 = nums2.length - 1;
        while (n2 <= n3) {
            if (nums1[n1] > nums2[n2]) {
                LinkedList<Integer> list = map.get(nums2[n2]);
                res[list.pollLast()] = nums1[n1];
                n1++;
                n2++;
            } else {
                LinkedList<Integer> list = map.get(nums2[n3]);
                res[list.pollLast()] = nums1[n1];
                n1++;
                n3--;
            }
        }

        return res;
    }
}

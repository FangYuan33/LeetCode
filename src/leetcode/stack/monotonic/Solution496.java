package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            numIndex.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer index = stack.pop();
                if (numIndex.containsKey(nums2[index])) {
                    res[numIndex.get(nums2[index])] = nums2[i];
                }
            }
            stack.push(i);
        }

        return res;
    }
}

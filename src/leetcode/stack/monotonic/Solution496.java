package leetcode.stack.monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 先维护好所有元素的第一个大值，并采用 hash 表进行映射
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}

package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOffer572 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SolutionOffer572().findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int[] nums = new int[target / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int left = 0, right = left + 1;
        int sum = nums[left] + nums[right];
        while (right < nums.length) {
            if (sum < target) {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                } else {
                    break;
                }
            } else if (sum > target) {
                sum -= nums[left];
                left++;
            } else {
                int[] element = new int[right - left + 1];
                for (int i = 0, j = left; i < element.length && j <= right; i++, j++) {
                    element[i] = nums[j];
                }
                res.add(element);

                sum -= nums[left];
                left++;
            }
        }

        int[][] resArray = new int[res.size()][1];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}

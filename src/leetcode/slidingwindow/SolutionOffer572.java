package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOffer572 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SolutionOffer572().findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int sum = 0;
        int left = 1, right = 1;
        while (right < target) {
            while (sum > target) {
                sum -= left++;
            }
            if (sum == target) {
                int[] element = new int[right - left];
                for (int i = left; i < right; i++) {
                    element[i - left] = i;
                }
                res.add(element);
            }

            sum += right++;
        }

        return res.toArray(new int[res.size()][]);
    }
}

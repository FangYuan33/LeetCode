package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOffer57 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SolutionOffer57().findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();

        int sum = 0;
        int left = 1, right = 1;
        while (right < target) {
            sum += right;

            while (sum >= target) {
                if (sum == target) {
                    res.add(initialElement(left, right));
                }
                sum -= left++;
            }

            right++;
        }

        return res.toArray(new int[res.size()][]);
    }

    private int[] initialElement(int left, int right) {
        int[] element = new int[right - left + 1];
        for (int i = 0; i < element.length; i++) {
            element[i] = left + i;
        }

        return element;
    }
}

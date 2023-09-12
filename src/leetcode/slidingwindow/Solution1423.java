package leetcode.slidingwindow;

public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }
        if (k == cardPoints.length) {
            return sum;
        }

        int temp = 0;
        int min = sum;
        int left = 0, right = 0;
        while (right < cardPoints.length) {
            temp += cardPoints[right];

            if (right - left + 1 == cardPoints.length - k) {
                min = Math.min(min, temp);
                temp -= cardPoints[left++];
            }

            right++;
        }

        return sum - min;
    }
}

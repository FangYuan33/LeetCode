package leetcode.slidingwindow;

public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0;
        int tCount = 0, fCount = 0;
        int left = 0, right = 0;
        while (right < answerKey.length()) {
            if (answerKey.charAt(right) == 'T') {
                tCount++;
            } else {
                fCount++;
            }
            int maxCount = Math.max(tCount, fCount);

            while (right - left + 1 - maxCount > k) {
                if (answerKey.charAt(left) == 'T') {
                    tCount--;
                } else {
                    fCount--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}

package leetcode.dp;

public class SolutionLCR166 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCR166().jewelleryValue(new int[][]{new int[]{1, 2, 5}, new int[]{3, 2, 1}}));
    }

    public int jewelleryValue(int[][] frame) {
        for (int i = 1; i < frame.length; i++) {
            frame[i][0] += frame[i - 1][0];
        }
        for (int i = 1; i < frame[0].length; i++) {
            frame[0][i] += frame[0][i - 1];
        }

        for (int i = 1; i < frame.length; i++) {
            for (int j = 1; j < frame[0].length; j++) {
                frame[i][j] += Math.max(frame[i - 1][j], frame[i][j - 1]);
            }
        }

        return frame[frame.length - 1][frame[0].length - 1];
    }
}

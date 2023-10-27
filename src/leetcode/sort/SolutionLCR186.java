package leetcode.sort;

import java.util.Arrays;

public class SolutionLCR186 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCR186().checkDynasty(new int[]{0, 6, 9, 0, 7}));
    }

    public boolean checkDynasty(int[] places) {
        Arrays.sort(places);

        int zeroNum = 0;
        for (int i = 0; i < places.length; i++) {
            if (places[i] == 0) {
                zeroNum++;
                continue;
            }
            if (i > 0 && places[i] == places[i - 1]) {
                return false;
            }
        }

        int num = places[places.length - 1] - places[zeroNum] + 1 - places.length + zeroNum;
        return zeroNum >= num;
    }
}

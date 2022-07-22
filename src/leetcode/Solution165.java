package leetcode;

public class Solution165 {

    public int compareVersion(String version1, String version2) {
        String[] number1 = version1.split("\\.");
        String[] number2 = version2.split("\\.");

        for (int i = 0; i < number1.length || i < number2.length; i++) {
            int value1 = 0, value2 = 0;

            if (i < number1.length) {
                value1 = Integer.parseInt(number1[i]);
            }
            if (i < number2.length) {
                value2 = Integer.parseInt(number2[i]);
            }

            if (value1 > value2) {
                return 1;
            }
            if (value1 < value2) {
                return -1;
            }
        }

        return 0;
    }
}


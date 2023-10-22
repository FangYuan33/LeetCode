package leetcode.doublepointer;

import java.util.Arrays;

public class Interview1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = Arrays.copyOfRange(A, 0, m);
        int a = 0, b = 0;
        int index = 0;
        int length = m + n;
        while (index < length) {
            if (a >= m) {
                A[index++] = B[b++];
                continue;
            }
            if (b >= n) {
                A[index++] = temp[a++];
                continue;
            }

            if (temp[a] <= B[b]) {
                A[index++] = temp[a++];
            } else {
                A[index++] = B[b++];
            }
        }
    }

}

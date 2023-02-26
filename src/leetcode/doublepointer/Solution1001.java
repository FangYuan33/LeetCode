package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.List;

public class Solution1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        List<Integer> list = new ArrayList<>(A.length);
        // 初始化两个数组的指针
        int i = 0, j = 0;

        while (i < m || j < n) {
            int cur = 0;

            // 如果有某个数组用完了
            if (i == m) {
                cur = B[j++];
            } else if (j == n) {
                cur = A[i++];
            } else {
                // 都没用完则比较大小
                if (A[i] >= B[j]) {
                    cur = B[j++];
                } else {
                    cur = A[i++];
                }
            }

            list.add(cur);
        }

        for (int k = 0; k < A.length; k++) {
            A[k] = list.get(k);
        }
    }
}

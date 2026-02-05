package graph;

import java.util.ArrayList;
import java.util.List;

public class Solution994 {
    private static final int[][] DIRECTION = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int res = 0;

        int fresh = 0;
        List<int[]> notFresh = new ArrayList<>();
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == 1) {
                    fresh++;
                } else if (grid[m][n] == 2) {
                    notFresh.add(new int[]{m, n});
                }
            }
        }

        while (fresh > 0 && !notFresh.isEmpty()) {
            res++;
            List<int[]> temp = notFresh;
            notFresh = new ArrayList<>();
            for (int[] tempNotFresh : temp) {
                for (int[] d : DIRECTION) {
                    int m = tempNotFresh[0] + d[0];
                    int n = tempNotFresh[1] + d[1];

                    if (m < grid.length && n < grid[0].length && m >= 0 && n >= 0) {
                        if (grid[m][n] == 1) {
                            grid[m][n] = 0;
                            fresh--;
                            notFresh.add(new int[]{m, n});
                        }
                    }
                }
            }
        }

        return fresh > 0 ? -1 : res;
    }

}

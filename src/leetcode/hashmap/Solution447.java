package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Solution447 {

    public static void main(String[] args) {
        System.out.println(new Solution447().numberOfBoomerangs(new int[][]{
                new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}
        }));
    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> disCount = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                int dist = x * x + y * y;
                disCount.put(dist, disCount.getOrDefault(dist, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : disCount.entrySet()) {
                Integer num = entry.getValue();
                res += num * (num - 1);
            }
        }

        return res;
    }
}

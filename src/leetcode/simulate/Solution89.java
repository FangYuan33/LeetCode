package leetcode.simulate;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        while (n-- > 0) {
            int m = res.size();
            for (int i = m - 1; i >= 0; i--) {
                res.set(i, res.get(i) << 1);
                res.add(res.get(i) + 1);
            }
        }

        return res;
    }
}

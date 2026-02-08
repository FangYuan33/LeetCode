package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution118 {

//        [1]
//        [1,1]
//        [1,2,1]
//        [1,3,3,1]
//        [1,4,6,4,1]
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> element = new ArrayList<>();
            // 第一个 1
            element.add(1);
            for (int j = 1; j < i; j++) {
                // 上一行
                element.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            // 末尾的 1
            element.add(1);
            res.add(element);
        }

        return res;
    }
}

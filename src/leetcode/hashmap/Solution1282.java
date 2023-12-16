package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> sizeGroup = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (sizeGroup.containsKey(groupSizes[i])) {
                ArrayList<Integer> group = sizeGroup.get(groupSizes[i]);
                if (group.size() == groupSizes[i]) {
                    ArrayList<Integer> newGroup = new ArrayList<>();
                    newGroup.add(i);
                    sizeGroup.put(group.size(), newGroup);
                    res.add(newGroup);
                } else {
                    group.add(i);
                }
            } else {
                ArrayList<Integer> newGroup = new ArrayList<>();
                newGroup.add(i);
                sizeGroup.put(groupSizes[i], newGroup);
                res.add(newGroup);
            }
        }

        return res;
    }

}

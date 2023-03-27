package business.greedyalgorithm;

import java.util.*;

public class One {

    /**
     * map key: id, value num
     * target 每组最大的数量
     * <p>
     * 根据map中num值进行分组，要保证每组num之和小于等于target
     * eg map: 1, 1; 2, 2; 3, 4; 4, 4; 5, 2
     * result: 1, 4; 2, 5; 3 or 1, 2, 5; 3; 4
     */
    public List<List<Integer>> split(Map<Integer, Integer> map, int target) {
        // 根据value值对map进行排序，这样根据贪心算法可以使每个数按顺序选到能与它匹配的最大值
        LinkedHashMap<Integer, Integer> linkedHashMap = orderByValue(map);

        return greedy(linkedHashMap, target);
    }

    private LinkedHashMap<Integer, Integer> orderByValue(Map<Integer, Integer> map) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(map.size());

        // 这里将map.entrySet()转换成list 通过比较器来实现降序排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }


    /**
     * 先确定一个值，然后猛拿大的值，直到拿不到为止，拿过的值都放到备忘录里去重
     */
    private List<List<Integer>> greedy(LinkedHashMap<Integer, Integer> linkedHashMap, int target) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        // 备忘录用于去重
        Set<Integer> memo = new HashSet<>(linkedHashMap.size());

        Integer[] keys = linkedHashMap.keySet().toArray(new Integer[0]);
        for (int i = 0; i < keys.length; i++) {
            // 去重
            if (memo.contains(keys[i])) {
                continue;
            }
            // 每次先选一个数然后再去匹配
            int sum = linkedHashMap.get(keys[i]);
            ArrayList<Integer> element = new ArrayList<>();
            element.add(keys[i]);

            // 开始猛拿
            for (int j = i + 1; j < keys.length; j++) {
                // 去重
                if (memo.contains(keys[j])) {
                    continue;
                }
                // 遍历了之后所有的数
                if (sum + linkedHashMap.get(keys[j]) <= target) {
                    sum += linkedHashMap.get(keys[j]);
                    element.add(keys[j]);
                    memo.add(keys[j]);
                }
            }
            // 遍历完成后说明没有再能够添加的值了
            res.add(element);
        }

        return res;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 4);
        map.put(4, 4);
        map.put(5, 2);
        map.put(6, 1);
        map.put(7, 1);
        map.put(8, 2);
        map.put(9, 4);
        map.put(10, 4);

        System.out.println(new One().split(map, 5));
    }
}

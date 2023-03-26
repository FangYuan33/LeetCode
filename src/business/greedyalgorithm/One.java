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
        this.target = target;
        res = new ArrayList<>();
        memo = new HashSet<>(map.size());

        // 根据value值对map进行排序，这样根据贪心算法可以使每个数按顺序选到能与它匹配的最大值
        LinkedHashMap<Integer, Integer> linkedHashMap = orderByValue(map);

        backtrack(new ArrayList<>(), 0, linkedHashMap);

        return res;
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

    private int target;
    List<List<Integer>> res;
    /**
     * 备忘录
     */
    private Set<Integer> memo;

    private void backtrack(ArrayList<Integer> element, int sum, LinkedHashMap<Integer, Integer> map) {
        // 找到最后了，没有合适的了就添加进来
        if (memo.size() == map.size()) {
            res.add(element);
            return;
        }


        // 遍历所有能选择的元素
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            // 备忘录判断
            if (memo.contains(key)) {
                continue;
            }

            // 获取该id对应的值
            Integer value = map.get(key);
            // 如果求和比目标值小的话，继续向下回溯
            if (sum + value <= target) {
                element.add(key);
                // 添加到备忘录
                memo.add(key);
                sum += value;

                backtrack(element, sum, map);
            } else {
                // 添加到备忘录
                memo.add(key);
                // 如果大于的话 不能添加
                backtrack(element, sum, map);
                // 从备忘录移除
                memo.remove(key);
            }

            // 回溯完成该值后 sum要清0
            sum = 0;
            element = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 4);
        map.put(4, 4);
        map.put(5, 2);

        System.out.println(new One().split(map, 5));
    }
}

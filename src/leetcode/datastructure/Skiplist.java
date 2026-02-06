package leetcode.datastructure;

import java.util.Random;

/**
 * Skiplist class represents a skip list data structure.
 */
public class Skiplist {

    private static final int MAX_LEVEL = 16;   // 最大层数
    private static final double P = 0.5;        // 晋升概率

    private final SkiplistNode head;   // 头节点
    private int level;            // 当前最高层数
    private final Random random;

    public Skiplist() {
        this.head = new SkiplistNode(-1, MAX_LEVEL);  // 哨兵节点
        this.level = 1;
        this.random = new Random();
    }

    /**
     * 搜索目标值是否存在
     * @param target 目标值
     * @return 是否存在
     */
    public boolean search(int target) {
        SkiplistNode current = head;

        // 从最高层开始查找
        for (int i = level - 1; i >= 0; i--) {
            // 在当前层向右移动，找到 < target 的最后一个节点
            while (current.next[i] != null && current.next[i].val < target) {
                current = current.next[i];
            }
        }

        // 移动到底层的下一个节点
        current = current.next[0];

        // 检查是否找到目标值
        return current != null && current.val == target;
    }

    public void add(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode current = head;

        // 1. 找到每层的插入位置（记录前驱节点）
        for (int i = level - 1; i >= 0; i--) {
            // 注意：这里是 < 而不是 <=，允许重复值
            while (current.next[i] != null && current.next[i].val < num) {
                current = current.next[i];
            }
            update[i] = current;
        }

        // 2. 随机生成新节点的层数
        int newLevel = randomLevel();

        // 3. 如果新层数超过当前层数，更新 head 的引用
        if (newLevel > level) {
            for (int i = level; i < newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        // 4. 创建新节点
        SkiplistNode newNode = new SkiplistNode(num, newLevel);

        // 5. 插入新节点到每一层
        for (int i = 0; i < newLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    /**
     * 删除一个指定值（如果存在多个，只删除一个）
     * @param num 要删除的值
     * @return 是否删除成功
     */
    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode current = head;

        // 1. 找到要删除的节点及其每层的前驱节点
        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].val < num) {
                current = current.next[i];
            }
            update[i] = current;
        }

        // 2. 获取目标节点
        current = current.next[0];

        // 3. 检查是否找到
        if (current == null || current.val != num) {
            return false;  // 未找到
        }

        // 4. 删除节点（从每一层中移除）
        for (int i = 0; i < level; i++) {
            if (update[i].next[i] != current) {
                break;  // 当前层没有该节点
            }
            update[i].next[i] = current.next[i];
        }

        // 5. 更新跳表的最大层数（删除空层）
        while (level > 1 && head.next[level - 1] == null) {
            level--;
        }

        return true;
    }

    /**
     * 随机生成节点层数
     * 通过 50% 概率决定是否增加层数
     */
    private int randomLevel() {
        int lvl = 1;
        // 每次有 50% 概率晋升到更高层
        while (lvl < MAX_LEVEL && random.nextDouble() < P) {
            lvl++;
        }
        return lvl;
    }

    private static class SkiplistNode {
        int val;                    // 存储的值
        SkiplistNode[] next;     // 每层的下一个节点

        public SkiplistNode(int val, int level) {
            this.val = val;
            this.next = new SkiplistNode[level];
        }
    }
}

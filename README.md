## 1. 链表

链表是一种 **递归** 的数据结构，与数组不同的是它不需要占用连续的内存空间，但是需要额外的空间保存后继节点的指针，以此将所有的链表节点串联起来。它的删除和插入操作比较高效，时间复杂度为 $O(1)$，但是想访问链表中某个值时，需要对链表进行遍历，时间复杂度为 $O(n)$。**链表是数组的一种重要的替代方式**。

### 链表反转

```java
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }
```

| 序号 | 题目链接                                                                           | 题解                                                                         | 备注       |
|----|--------------------------------------------------------------------------------|----------------------------------------------------------------------------|----------|
| 1  | [剑指 Offer 24. 反转链表 简单](https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/) | [SolutionOffer24.java](src%2Fleetcode%2Flinkedlist%2FSolutionOffer24.java) |          |
| 2  | [234. 回文链表 简单](https://leetcode.cn/problems/palindrome-linked-list/)           | [Solution234.java](src%2Fleetcode%2Flinkedlist%2FSolution234.java)         | 快慢指针分开链表 |
| 3  | [92. 反转链表 II 中等](https://leetcode.cn/problems/reverse-linked-list-ii/)         | [Solution92.java](src%2Fleetcode%2Flinkedlist%2FSolution92.java)           |          |
| 4  | [25. K 个一组翻转链表 困难](https://leetcode.cn/problems/reverse-nodes-in-k-group/)     | [Solution25.java](src%2Fleetcode%2Flinkedlist%2FSolution25.java)           |          |

### 递归

| 序号 | 题目链接                                                                                                 | 题解                                                                         | 备注                          |
|----|------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|-----------------------------|
| 1  | [剑指 Offer 06. 从尾到头打印链表 简单](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)     | [SolutionOffer06.java](src%2Fleetcode%2Flinkedlist%2FSolutionOffer06.java) |                             |
| 2  | [剑指 Offer 35. 复杂链表的复制 中等](https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/)              | [SolutionOffer35.java](src%2Fleetcode%2Flinkedlist%2FSolutionOffer35.java) |                             |
| 3  | [24. 两两交换链表中的节点 中等](https://leetcode.cn/problems/swap-nodes-in-pairs/)                               | [Solution24.java](src%2Fleetcode%2Flinkedlist%2FSolution24.java)           |                             |
| 4  | [剑指 Offer 25. 合并两个排序的链表 简单](https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/) | [SolutionOffer25.java](src%2Fleetcode%2Flinkedlist%2FSolutionOffer25.java) |                             |
| 5  | [23. 合并K个升序链表 困难](https://leetcode.cn/problems/merge-k-sorted-lists/)                                | [Solution23.java](src%2Fleetcode%2Flinkedlist%2FSolution23.java)           | 分治的思想(想想归并排序)               |
| 6  | [148. 排序链表 中等](https://leetcode.cn/problems/sort-list/)                                              | [Solution148.java](src%2Fleetcode%2Flinkedlist%2FSolution148.java)         | 也是分治的思想，但是它的难度是中等，其实和上一题差不多 |
| 7  | [430. 扁平化多级双向链表 中等](https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/)           | [Solution430.java](src%2Fleetcode%2Flinkedlist%2FSolution430.java)         |                             |

### 双指针、快慢指针

| 序号 | 题目链接                                                                                                     | 题解                                                                         | 备注 |
|----|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|----|
| 1  | [剑指 Offer 22. 链表中倒数第k个节点 简单](https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/) | [SolutionOffer22.java](src%2Fleetcode%2Flinkedlist%2FSolutionOffer22.java) |    |
| 2  | [141. 环形链表 简单](https://leetcode.cn/problems/linked-list-cycle/)                                          | [Solution141.java](src%2Fleetcode%2Flinkedlist%2FSolution141.java)         |    |
| 3  | [142. 环形链表 II 中等](https://leetcode.cn/problems/linked-list-cycle-ii/)                                    | [Solution142.java](src%2Fleetcode%2Flinkedlist%2FSolution142.java)         |    |
| 4  | [160. 相交链表 简单](https://leetcode.cn/problems/intersection-of-two-linked-lists/)                           | [Solution160.java](src%2Fleetcode%2Flinkedlist%2FSolution160.java)         |    |

### 前驱节点在删除链表节点中的应用

| 序号 | 题目链接                                                                                          | 题解                                                                         | 备注 |
|----|-----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|----|
| 1  | [剑指 Offer 18. 删除链表的节点 简单](https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/)  | [SolutionOffer18.java](src%2Fleetcode%2Flinkedlist%2FSolutionOffer18.java) |    |
| 2  | [83. 删除排序链表中的重复元素 简单](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)       | [Solution83.java](src%2Fleetcode%2Flinkedlist%2FSolution83.java)           |    |
| 3  | [82. 删除排序链表中的重复元素 II 中等](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/) | [Solution82.java](src%2Fleetcode%2Flinkedlist%2FSolution82.java)           |    |
| 4  | [19. 删除链表的倒数第 N 个结点 中等](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)       | [Solution19.java](src%2Fleetcode%2Flinkedlist%2FSolution19.java)           |    |
| 5  | [725. 分隔链表 中等](https://leetcode.cn/problems/split-linked-list-in-parts/)                      | [Solution725.java](src%2Fleetcode%2Flinkedlist%2FSolution725.java)         |    |

### 推导

| 序号 | 题目链接                                                                    | 题解                                                                               | 备注 |
|----|-------------------------------------------------------------------------|----------------------------------------------------------------------------------|----|
| 1  | [328. 奇偶链表 中等](https://leetcode.cn/problems/odd-even-linked-list/)      | [Solution328.java](src%2Fleetcode%2Flinkedlist%2FSolution328.java)               |    |
| 2  | [382. 链表随机节点 中等](https://leetcode.cn/problems/linked-list-random-node/) | [Solution382.java](src%2Fleetcode%2Flinkedlist%2FSolution382.java)               |    |
| 3  | [剑指 Offer II 029. 排序的循环链表 中等](https://leetcode.cn/problems/4ueAj6/)     | [SolutionOfferTwo29.java](src%2Fleetcode%2Flinkedlist%2FSolutionOfferTwo29.java) |    |
| 4  | [面试题 02.05. 链表求和 中等](https://leetcode.cn/problems/sum-lists-lcci/)      | [Solution0205.java](src%2Fleetcode%2Flinkedlist%2FSolution0205.java)             |    |
| 5  | [445. 两数相加 II 中等](https://leetcode.cn/problems/add-two-numbers-ii/)     | [Solution445.java](src%2Fleetcode%2Flinkedlist%2FSolution445.java)               |    |
| 6  | [817. 链表组件 中等](https://leetcode.cn/problems/linked-list-components/)    | [Solution817.java](src%2Fleetcode%2Flinkedlist%2FSolution817.java)               |    |

## 2. 数据结构

| 序号 | 题目链接                                                                              | 题解                                                                            | 备注 |
|----|-----------------------------------------------------------------------------------|-------------------------------------------------------------------------------|----|
| 1  | [146. LRU 缓存 中等](https://leetcode.cn/problems/lru-cache/)                         | [LRUCacheHashMap.java](src%2Fleetcode%2Fdatastructure%2FLRUCacheHashMap.java) |    |
| 2  | [460. LFU 缓存 困难](https://leetcode.cn/problems/lfu-cache/)                         | [LFUCache.java](src%2Fleetcode%2Fdatastructure%2FLFUCache.java)               |    |
| 3  | [432. 全 O(1) 的数据结构 困难](https://leetcode.cn/problems/all-oone-data-structure/)     | [AllOne.java](src%2Fleetcode%2Fdatastructure%2FAllOne.java)                   |    |
| 4  | [707. 设计链表 中等](https://leetcode.cn/problems/design-linked-list/)                  | [MyLinkedList.java](src%2Fleetcode%2Fdatastructure%2FMyLinkedList.java)       |    |
| 5  | [641. 设计循环双端队列 中等](https://leetcode.cn/problems/design-circular-deque/)           | [MyCircularDeque.java](src%2Fleetcode%2Fdatastructure%2FMyCircularDeque.java) |    |
| 6  | [1206. 设计跳表 困难](https://leetcode.cn/problems/design-skiplist/)                    |                                                                               |    |
| 7  | [208. 实现 Trie (前缀树) 中等](https://leetcode.cn/problems/implement-trie-prefix-tree/) |                                                                               |    |

## 3. 栈

栈是一种基于 **后进先出（LIFO）策略** 的集合类型，这就需要我们在对值进行处理时注意结果值有没有对顺序的要求，因为入栈到出栈是倒序的。

- 应用: 函数调用栈、括号的匹配、双栈实现浏览器的前进和后退功能、JVM栈、电子邮件的存放、算数表达式的求值(操作数栈和运算符栈)

| 序号 | 题目链接                                                                           | 题解                                                                                          | 备注 |
|----|--------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|----|
|    | [20. 有效的括号 简单](https://leetcode.cn/problems/valid-parentheses/)                | [Solution20.java](src%2Fleetcode%2Fstack%2FSolution20.java)                                 |    |
|    | [232. 用栈实现队列 简单](https://leetcode.cn/problems/implement-queue-using-stacks/)   | [MyQueue.java](src%2Fleetcode%2Fstack%2FMyQueue.java)                                       |    |
|    | [155. 最小栈 中等](https://leetcode.cn/problems/min-stack/)                         | [MinStack.java](src%2Fleetcode%2Fstack%2FMinStack.java)                                     |    |
|    | [385. 迷你语法分析器 中等](https://leetcode.cn/problems/mini-parser/)                   | [【宫水三叶】栈运用模拟题](https://leetcode.cn/problems/mini-parser/solutions/1422125/by-ac_oier-zuy6/) |    |
|    | [636. 函数的独占时间 中等](https://leetcode.cn/problems/exclusive-time-of-functions/)   | [Solution636.java](src%2Fleetcode%2Fstack%2FSolution636.java)                               |    |
|    | [735. 行星碰撞 中等](https://leetcode.cn/problems/asteroid-collision/)               | [Solution735.java](src%2Fleetcode%2Fstack%2FSolution735.java)                               |    |
|    | [856. 括号的分数 中等](https://leetcode.cn/problems/score-of-parentheses/)            | [Solution856.java](src%2Fleetcode%2Fstack%2FSolution856.java)                               |    |
|    | [1106. 解析布尔表达式 困难](https://leetcode.cn/problems/parsing-a-boolean-expression/) | [Solution1106.java](src%2Fleetcode%2Fstack%2FSolution1106.java)                             |    |

1. [剑指 Offer 09. 用两个栈实现队列 简单](https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)
2. [剑指 Offer 30. 包含min函数的栈 简单](https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/)
4. [剑指 Offer 31. 栈的压入、弹出序列 中等](https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

### 单调栈

单调递增栈可以找到**距离当前栈顶元素左右两侧最近的小于当前元素的值**（单调递减栈相反，它能找到距离当前栈顶元素左右两侧最近的大于当前值的元素）。
以单调递增栈为例，较小的值入栈的过程就像是它要"挤走"所有比它大的值，比它大的值不断地（while条件）出栈，
而这个入栈的小值就是这些出栈元素右侧距离最近的小于当前元素的值。

递增栈模版如下

```java
Stack<Integer> stack = new Stack<>();

for (int i = 0; i < nums.length; i++) {
    while (!stack.isEmpty() && nums[i] < stack.peek()) {
        // 注意这个里弹出索引的妙用
        int index = stack.pop();
    }
    // 这里一般压入索引
    stack.push(i);
}
```   

1. [84. 柱状图中最大的矩形 困难](https://leetcode.cn/problems/largest-rectangle-in-histogram/): 单调递增栈
2. [42. 接雨水 困难](https://leetcode.cn/problems/trapping-rain-water/): 单调递减栈
3. [503. 下一个更大元素 II 中等](https://leetcode.cn/problems/next-greater-element-ii/): 单调递减栈

## 2. 二叉树

- 前、中、后序遍历模板

```java
    void traverse(TreeNode root) {
        // 前序遍历
        traverse(root);
        // 中序遍历
        traverse(root);
        // 后续遍历
        traverse(root);
    }
```

### 前序遍历

前序遍历在进入某个节点前执行

1. [144. 二叉树的前序遍历 简单](https://leetcode.cn/problems/binary-tree-preorder-traversal/)
2. [剑指 Offer 34. 二叉树中和为某一值的路径 中等](https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)
3. [剑指 Offer 27. 二叉树的镜像 简单](https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/)
4. [剑指 Offer 28. 对称的二叉树 简单](https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/)
5. [617. 合并二叉树 简单](https://leetcode.cn/problems/merge-two-binary-trees/)
6. [剑指 Offer 07. 重建二叉树 中等](https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/): 前序拿节点值，中序只用来定位根节点索引以此区分右子树

### 中序遍历

中序遍历注意是否需要保存前驱节点指针

1. [94. 二叉树的中序遍历 简单](https://leetcode.cn/problems/binary-tree-inorder-traversal/)
2. [剑指 Offer 54. 二叉搜索树的第k大节点 简单](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)
3. [98. 验证二叉搜索树 中等](https://leetcode.cn/problems/validate-binary-search-tree/)
4. [剑指 Offer 36. 二叉搜索树与双向链表 中等](https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

### 后序遍历

后序遍历在离开某个节点后执行

1. [145. 二叉树的后序遍历 简单](https://leetcode.cn/problems/binary-tree-postorder-traversal/)
2. [剑指 Offer 55 - I. 二叉树的深度 简单](https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/)
3. [剑指 Offer 55 - II. 平衡二叉树 简单](https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/)
4. [剑指 Offer 33. 二叉搜索树的后序遍历序列 中等](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

### 层序遍历

层序遍历采用BFS(广度优先搜索)，用它来寻找路径的话，一定是最小的，解题模板如下

```java
// 计算启动到终点的最短距离
inf bfs(Node node, Node target) {
    // bfs算法必要的队列
    Queue<Node> queue;
    // 避免走回头路
    Set<Node> visited;
    // 走的距离/步数
    int step = 0;
    
    // 起点入队
    queue.offer(node);
    visited.add(node);
    
    while(queue.isNotEmpty()) {
        int size = queue.size();
        // 将当前层中的所有节点向四周扩散
        for (int i = 0; i < size; i++) {
            Node cur = queue.poll();
            // 如果到达终点则直接结束返回最短路径
            if (cur == target) {
                return step;    
            }
            // 将cur的相邻节点放入队列，二叉树比较简单，判断左右即可，若为图，则需遍历它的邻接表
            for (Node n : cur.adj()) {
                if (n not in visited) {
                    queue.offer(n);
                    visited.add(n);
                }    
            }   
        }
        // 距离 + 1
        step++;
    }
    
}
```

1. [111. 二叉树的最小深度 简单](https://leetcode.cn/problems/minimum-depth-of-binary-tree/)
2. [102. 二叉树的层序遍历 中等](https://leetcode.cn/problems/binary-tree-level-order-traversal/)
3. [剑指 Offer 32 - I. 从上到下打印二叉树 中等](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)
4. [剑指 Offer 32 - III. 从上到下打印二叉树 III 中等](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)
5. [199. 二叉树的右视图 中等](https://leetcode.cn/problems/binary-tree-right-side-view/)
6. [剑指 Offer 37. 序列化二叉树 困难](https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/)

### 最近公共祖先问题

1. [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 简单](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
2. [剑指 Offer 68 - II. 二叉树的最近公共祖先先 简单](https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
   
### 递归

1. [剑指 Offer 26. 树的子结构 中等](https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/)
2. [114. 二叉树展开为链表 中等](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/): 需要推导一下

## 3. 动态规划

动态规划一般都用来求**最值**，它的问题核心是**穷举**，如果使用回溯解决问题时，要考虑使用备忘录对其进行优化。解题时需要考虑以下几点

1. 这个问题的 base case 是什么？
2. 它的子问题是什么？再想想它的状态呢？
3. 它的状态转移方程是怎样的？
4. 如何定义dp来表现状态或采用回溯法时如何用方法来表示它的状态？

### 最值问题

```java
// 解题模板
dp[0][0][...] = base case;
for 状态1 in 状态1中的所有值
    for 状态2 in 状态2中的所有值
        for ...
            dp[状态1][状态2][...] = 状态转移方程 = 最值;
```

1. [剑指 Offer 10- II. 青蛙跳台阶问题 简单](https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)
2. [322. 零钱兑换 中等](https://leetcode.cn/problems/coin-change/)
3. [64. 最小路径和 中等](https://leetcode.cn/problems/minimum-path-sum/)
4. [剑指 Offer 42. 连续子数组的最大和 简单](https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)
5. [198. 打家劫舍 中等](https://leetcode.cn/problems/house-robber/)
6. [213. 打家劫舍 II 中等](https://leetcode.cn/problems/house-robber-ii/)
7. [剑指 Offer 14- I. 剪绳子 中等](https://leetcode.cn/problems/jian-sheng-zi-lcof/)
8. [剑指 Offer 46. 把数字翻译成字符串 中等](https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)
9. [剑指 Offer 47. 礼物的最大价值 中等](https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/)
10. [剑指 Offer 49. 丑数 中等](https://leetcode.cn/problems/chou-shu-lcof/)
11. [72. 编辑距离 困难](https://leetcode.cn/problems/edit-distance/)

### 子序列问题

涉及子序列，一般情况下时间复杂度为 $O(n^2)$，那么就跑不了双层的for循环

```java
// 解题模板，针对数组的最长递增子序列问题，一维数组
int n = array.length;
int[] dp = new int[n];

for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
        dp[i] = 最值;    
    }
}
```

```java
// 解题模板，针对两个数组或字符串的子序列问题
int n1 = array1.length;
int n2 = array2.length;
int[][] dp = new int[n1][n2];

for (int i = 0; i < n1; i++) {
    for (int j = 0; j < n2; j++) {
        if (n1[i] == n2[j]) {
            dp[i][j] = 
        } else {
            dp[i][j] = 
        }    
    }    
}
```


1. [1143. 最长公共子序列 中等](https://leetcode.cn/problems/longest-common-subsequence/)
2. [300. 最长递增子序列 中等](https://leetcode.cn/problems/longest-increasing-subsequence/)
3. [516. 最长回文子序列 中等](https://leetcode.cn/problems/longest-palindromic-subsequence/): 回文串系列都是反向遍历
4. [1312. 让字符串成为回文串的最少插入次数 困难](https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/)

### 其他问题

1. [剑指 Offer 60. n个骰子的点数 中等](https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/)

## 4. 回溯

回溯相当于穷举搜索，但是回溯算法的复杂度非常高，只能用来解决小规模的数据问题。回溯问题可以想成 **"决策树"** ，在树的每个节点从 **"选择列表"** 里做出不同的决策，
而当走过的 **"路径"** 满足结束条件时即为答案之一。回溯算法用于解决**全排列、八皇后、正则表达式匹配和某些做选择的动态规划**问题，它的解题模板如下

```xml
result = [];
def backtrack(路径, 选择列表):
    if 满足结束条件
        result.add(路径)
        return
    
    for 选择 in 选择列表: 
        // 做选择
        路径.add(选择)
        backtrack(路径, 选择列表)
        // 撤销选择
        路径.remove(选择)
```

1. [46. 全排列 中等](https://leetcode.cn/problems/permutations/)
2. [剑指 Offer 38. 字符串的排列 中等](https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/)
3. [39. 组合总和 中等](https://leetcode.cn/problems/combination-sum/)
4. [40. 组合总和 II 中等](https://leetcode.cn/problems/combination-sum-ii/)
5. [78. 子集 中等](https://leetcode.cn/problems/subsets/)
6. [22. 括号生成 中等](https://leetcode.cn/problems/generate-parentheses/)
7. [面试题 08.12. 八皇后 困难](https://leetcode.cn/problems/eight-queens-lcci/)
8. [10. 正则表达式匹配 困难](https://leetcode.cn/problems/regular-expression-matching/)
9. [337. 打家劫舍 III 中等](https://leetcode.cn/problems/house-robber-iii/)
10. [139. 单词拆分 中等](https://leetcode.cn/problems/word-break/): 字符串API `startsWith(s)` 判断字符串是否以某字符串开头

## 5. 贪心算法

1. [121. 买卖股票的最佳时机 简单](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)
2. [122. 买卖股票的最佳时机 II 中等](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)
3. [123. 买卖股票的最佳时机 III 困难](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/)
4. [135. 分发糖果 困难](https://leetcode.cn/problems/candy/): 向左向右分别分一次的想法如果能想到就太简单了
5. [55. 跳跃游戏 中等](https://leetcode.cn/problems/jump-game/)

## 6. 递归

递归矩阵问题注意单元格重复访问的问题，一般用 `visited[][]` 来标记是否访问过

1. [200. 岛屿数量 中等](https://leetcode.cn/problems/number-of-islands/)
2. [剑指 Offer 12. 矩阵中的路径 中等](https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/)
3. [面试题13. 机器人的运动范围 中等](https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

## 7. 二分查找

**思路很简单，细节是魔鬼**。使用二分查找法的标志不是数组有序（单调）而是**数据的两段性**，只要一段满足某个性质，另一段不满足某个性质，那么就可以使用二分法。
双闭区间模板如下，不过注意其中的细节可能改变。

```java
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 这里变？
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                // 这里变？
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 这里变？
                right = mid - 1;
            } else {
                // 还是这里变？
                return mid;
            }
        }

        return -1;
    }
```

### 数组有序

1. [剑指 Offer 53 - I. 在排序数组中查找数字 I 简单](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)
2. [154. 寻找旋转排序数组中的最小值 II 困难](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/)
3. [剑指 Offer 04. 二维数组中的查找 中等](https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

### 数组无序

1. [162. 寻找峰值 中等](https://leetcode.cn/problems/find-peak-element/)

## 8. 双指针

双指针解题考虑点

- 数组是否有序？
- 初始指针怎么定义，是在用一个位置还是在数组两边？
- 指针移动的条件是什么？
- 是否有连续子数组、连续子字符串要求？有的话优先考虑滑动窗口

针对数组中两个值的问题，从数组两边开始找的情况；针对回文串问题，从两边开始比

1. [15. 三数之和 中等](https://leetcode.cn/problems/3sum/)
2. [11. 盛最多水的容器 中等](https://leetcode.cn/problems/container-with-most-water/)
3. [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 简单](https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)
4. [125. 验证回文串 简单](https://leetcode.cn/problems/valid-palindrome/)

两个有序数组的合并问题，一个数组分别一个指针

1. [面试题 10.01. 合并排序的数组 简单](https://leetcode.cn/problems/sorted-merge-lcci/)

## 9. 滑动窗口

滑动窗口的变化条件**需要有准确的规则**。如果数组是无序且包含的元素并**不都是非负数**的话，往往窗口的变化条件比较难判断，可能无法使用该方法求解

1. [209. 长度最小的子数组 中等](https://leetcode.cn/problems/minimum-size-subarray-sum/)
2. [剑指 Offer 57 - II. 和为s的连续正数序列 简单](https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)
3. [713. 乘积小于 K 的子数组 中等](https://leetcode.cn/problems/subarray-product-less-than-k/)
4. [56. 合并区间 中等](https://leetcode.cn/problems/merge-intervals/)
5. [剑指 Offer 48. 最长不含重复字符的子字符串 中等](https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)
6. [76. 最小覆盖子串 困难](https://leetcode.cn/problems/minimum-window-substring/)

## 10. 字符串

### 字符串操作

- `s.trim()` 去掉字符串两边的空格

1. [14. 最长公共前缀 简单](https://leetcode.cn/problems/longest-common-prefix/)
2. [151. 反转字符串中的单词 中等](https://leetcode.cn/problems/reverse-words-in-a-string/)

### 字符转数字

- `s.charAt(i) - '0'` = 数字
- `Integer.parseInt()` 字符串转整数自动忽略前导0

1. [165. 比较版本号 中等](https://leetcode.cn/problems/compare-version-numbers/): 
2. [8. 字符串转换整数 (atoi) 中等](https://leetcode.cn/problems/string-to-integer-atoi/)
3. [43. 字符串相乘 中等](https://leetcode.cn/problems/multiply-strings/)

## 11. 哈希

1. [1. 两数之和 简单](https://leetcode.cn/problems/two-sum/)
2. [剑指 Offer 39. 数组中出现次数超过一半的数字 简单](https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)
3. [41. 缺失的第一个正数 困难](https://leetcode.cn/problems/first-missing-positive/): 自建简单hash函数，使得该位置的数和索引成关联关系
4. [剑指 Offer 03. 数组中重复的数字 简单](https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/): 同样可以采用上述思路写
5. [剑指 Offer 35. 复杂链表的复制 中等](https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

## 12. 栈/队列/堆
   
### 队列/双向队列

#### 单调队列

单调队列则是在单调栈的基础上实现**数据的两端操作**

1. [239. 滑动窗口最大值 困难](https://leetcode.cn/problems/sliding-window-maximum/)
2. [面试题59 - II. 队列的最大值 中等](https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/)

### 堆

堆用于解决**Top K问题**、**求中位数**或**中位数变体问题**(99值问题)

1. [剑指 Offer 40. 最小的k个数 简单](https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/): 大顶堆
2. [215. 数组中的第K个最大元素 中等](https://leetcode.cn/problems/kth-largest-element-in-an-array/): 小顶堆
3. [703. 数据流中的第 K 大元素 简单](https://leetcode.cn/problems/kth-largest-element-in-a-stream/): 小顶堆
4. [剑指 Offer 41. 数据流中的中位数 困难](https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/): 中位数问题用两个堆根本不难
5. [4. 寻找两个正序数组的中位数 困难](https://leetcode.cn/problems/median-of-two-sorted-arrays/)

## 13. 前缀和

**包含负数**的连续子数组，非负数连续子数组问题可以使用滑动窗口求解

1. [560. 和为 K 的子数组 中等](https://leetcode.cn/problems/subarray-sum-equals-k/)
2. [525. 连续数组 中等](https://leetcode.cn/problems/contiguous-array/)
3. [238. 除自身以外数组的乘积 中等](https://leetcode.cn/problems/product-of-array-except-self/)

## 14. 排序算法

1. [剑指 Offer 51. 数组中的逆序对 困难](https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/): 归并排序
2. [75. 颜色分类 中等](https://leetcode.cn/problems/sort-colors/): 有点儿像快排的哨兵交换环节

## 15. 位运算

1. [剑指 Offer 15. 二进制中1的个数 简单](https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)
2. [剑指 Offer 16. 数值的整数次方 中等](https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)
3. [137. 只出现一次的数字 II 中等](https://leetcode.cn/problems/single-number-ii/)

## 17. 其他

1. [面试题45. 把数组排成最小的数 中等](https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/): 自定义排序
2. [面试题61. 扑克牌中的顺子 简单](https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

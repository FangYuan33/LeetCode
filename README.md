### 1. 链表

#### 链表反转

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

1. [206. 反转链表 简单](https://leetcode.cn/problems/reverse-linked-list/)
2. [剑指 Offer 06. 从尾到头打印链表 简单](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/): 也可递归解决
3. [234. 回文链表 简单](https://leetcode.cn/problems/palindrome-linked-list/): 快慢指针分开链表
4. [92. 反转链表 II 中等](https://leetcode.cn/problems/reverse-linked-list-ii/)
5. [25. K 个一组翻转链表 困难](https://leetcode.cn/problems/reverse-nodes-in-k-group/)

#### 递归 合并链表

1. [21. 合并两个有序链表 简单](https://leetcode.cn/problems/merge-two-sorted-lists/)
2. [23. 合并K个升序链表 困难](https://leetcode.cn/problems/merge-k-sorted-lists/): 分治的思想(想想归并排序)
3. [148. 排序链表 中等](https://leetcode.cn/problems/sort-list/): 也是分治的思想，但是它的难度是中等，其实和上一题差不多

#### 双指针、快慢指针

1. [剑指 Offer 22. 链表中倒数第k个节点 简单](https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
2. [19. 删除链表的倒数第 N 个结点 中等](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)
3. [141. 环形链表 简单](https://leetcode.cn/problems/linked-list-cycle/)
4. [142. 环形链表 II 中等](https://leetcode.cn/problems/linked-list-cycle-ii/)

#### 前驱节点在删除链表节点中的应用

1. [剑指 Offer 18. 删除链表的节点 简单](https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/)
2. [83. 删除排序链表中的重复元素 简单](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)
3. [82. 删除排序链表中的重复元素 II 中等](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/)

#### 辅助栈

1. [445. 两数相加 II 中等](https://leetcode.cn/problems/add-two-numbers-ii/)

#### 推导

1. [328. 奇偶链表 中等](https://leetcode.cn/problems/odd-even-linked-list/)
2. [剑指 Offer 52. 两个链表的第一个公共节点 简单](https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

### 2. 二叉树

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

#### 前序遍历

前序遍历在进入某个节点前执行

1. [144. 二叉树的前序遍历 简单](https://leetcode.cn/problems/binary-tree-preorder-traversal/)
2. [剑指 Offer 34. 二叉树中和为某一值的路径 中等](https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)
3. [剑指 Offer 27. 二叉树的镜像 简单](https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/)
4. [剑指 Offer 28. 对称的二叉树 简单](https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/)
5. [617. 合并二叉树 简单](https://leetcode.cn/problems/merge-two-binary-trees/)
6. [剑指 Offer 07. 重建二叉树 中等](https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/): 前序拿节点值，中序只用来定位根节点索引以此区分右子树

#### 中序遍历

1. [94. 二叉树的中序遍历 简单](https://leetcode.cn/problems/binary-tree-inorder-traversal/)
2. [剑指 Offer 54. 二叉搜索树的第k大节点 简单](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)
3. [98. 验证二叉搜索树 中等](https://leetcode.cn/problems/validate-binary-search-tree/)
4. [剑指 Offer 36. 二叉搜索树与双向链表 中等](https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

#### 后序遍历

后序遍历在离开某个节点后执行

1. [145. 二叉树的后序遍历 简单](https://leetcode.cn/problems/binary-tree-postorder-traversal/)
2. [剑指 Offer 55 - I. 二叉树的深度 简单](https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/)
3. [剑指 Offer 55 - II. 平衡二叉树 简单](https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/)
4. [剑指 Offer 33. 二叉搜索树的后序遍历序列 中等](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

#### 层序遍历

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

#### 最近公共祖先问题

1. [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 简单](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
2. [剑指 Offer 68 - II. 二叉树的最近公共祖先先 简单](https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
   
#### 递归

1. [剑指 Offer 26. 树的子结构 中等](https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/)

### 3. 动态规划

动态规划一般都用来求**最值**，它的问题核心是**穷举**，如果使用回溯解决问题时，要考虑使用备忘录对其进行优化。解题时需要考虑以下几点

1. 这个问题的 base case 是什么？
2. 它的子问题是什么？再想想它的状态呢？
3. 它的状态转移方程是怎样的？
4. 如何定义dp来表现状态或采用回溯法时如何用方法来表示它的状态？

#### 最值问题

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

#### 子序列问题

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

#### 其他问题

1. [剑指 Offer 60. n个骰子的点数 中等](https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/)

### 4. 回溯

回溯相当于穷举搜索，但是回溯算法的复杂度非常高，只能用来解决小规模的数据问题。回溯问题可以想成 **"决策树"** ，在树的每个节点从 **"选择列表"** 里做出不同的决策，
而走过的 **"路径"** 当满足结束条件时即为答案之一。回溯算法用于解决**全排列、八皇后、正则表达式匹配和某些做选择的动态规划**问题，它的解题模板如下

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
3. [40. 组合总和 II 中等](https://leetcode.cn/problems/combination-sum-ii/)
4. [78. 子集 中等](https://leetcode.cn/problems/subsets/)
5. [22. 括号生成 中等](https://leetcode.cn/problems/generate-parentheses/)
6. [面试题 08.12. 八皇后 困难](https://leetcode.cn/problems/eight-queens-lcci/)
7. [10. 正则表达式匹配 困难](https://leetcode.cn/problems/regular-expression-matching/)
8. [337. 打家劫舍 III 中等](https://leetcode.cn/problems/house-robber-iii/)

### 5. 贪心算法

1. [121. 买卖股票的最佳时机 简单](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)
2. [122. 买卖股票的最佳时机 II 中等](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)
3. [123. 买卖股票的最佳时机 III 困难](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/)
4. [135. 分发糖果 困难](https://leetcode.cn/problems/candy/): 向左向右分别分一次的想法如果能想到就太简单了

### 6. 递归

递归矩阵问题注意单元格重复访问的问题，一般用 `visited[][]` 来标记是否访问过

1. [200. 岛屿数量 中等](https://leetcode.cn/problems/number-of-islands/)
2. [剑指 Offer 12. 矩阵中的路径 中等](https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/)
3. [面试题13. 机器人的运动范围 中等](https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

### 7. 二分查找

**思路很简单，细节是魔鬼**。双闭区间模板如下，不过注意其中的细节可能改变

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

#### 数组有序

1. [704. 二分查找 简单](https://leetcode.cn/problems/binary-search/)
2. [剑指 Offer 53 - I. 在排序数组中查找数字 I 简单](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

#### 旋转有序数组

1. [剑指 Offer 11. 旋转数组的最小数字 简单](https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)
2. [154. 寻找旋转排序数组中的最小值 II 困难](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/)

#### 二维数组

1. [剑指 Offer 04. 二维数组中的查找 中等](https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

#### 无序

> 对于无序数组，那么结束条件和搜索区间的变化就不能盲目的遵循 双闭区间 或 左闭右开区间

1. [162. 寻找峰值 中等](https://leetcode.cn/problems/find-peak-element/)

### 8. 双指针

- 判断数组是否有序，指针移动的条件是什么？

#### 有序

1. [剑指 Offer 57. 和为s的两个数字 简单](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/)
2. [剑指 Offer 57 - II. 和为s的连续正数序列 简单](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/)
3. [15. 三数之和 中等](https://leetcode.cn/problems/3sum/)

#### 滑动窗口（无序）

- 子数组、子字符串问题

1. [209. 长度最小的子数组 中等](https://leetcode.cn/problems/minimum-size-subarray-sum/)
2. [713. 乘积小于 K 的子数组 中等](https://leetcode.cn/problems/subarray-product-less-than-k/)
3. [239. 滑动窗口最大值 困难](https://leetcode.cn/problems/sliding-window-maximum/)

#### 待归类

1. [面试题 10.01. 合并排序的数组 简单](https://leetcode.cn/problems/sorted-merge-lcci/)
2. [剑指 Offer II 018. 有效的回文 简单](https://leetcode.cn/problems/XltzEq/)
3. [56. 合并区间 中等](https://leetcode.cn/problems/merge-intervals/)
4. [11. 盛最多水的容器 中等](https://leetcode.cn/problems/container-with-most-water/)
5. [42. 接雨水 困难](https://leetcode.cn/problems/trapping-rain-water/)
7. [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 简单](https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)
8. [剑指 Offer 48. 最长不含重复字符的子字符串 中等](https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)


### 9. 前缀和

- 连续子数组

1. [560. 和为 K 的子数组 中等](https://leetcode.cn/problems/subarray-sum-equals-k/)
2. [525. 连续数组 中等](https://leetcode.cn/problems/contiguous-array/)

### 10. 哈希

1. [1. 两数之和 简单](https://leetcode.cn/problems/two-sum/)
2. [剑指 Offer 39. 数组中出现次数超过一半的数字 简单](https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)
3. [41. 缺失的第一个正数 困难](https://leetcode.cn/problems/first-missing-positive/submissions/): 自建hash函数
4. [剑指 Offer 03. 数组中重复的数字 简单](https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/): 同样可以采用上述思路写
5. [剑指 Offer 35. 复杂链表的复制 中等](https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

### 11. 栈/队列/堆

#### 栈

- 判断括号是否有效

1. [剑指 Offer 09. 用两个栈实现队列 简单](https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)
2. [剑指 Offer 30. 包含min函数的栈 简单](https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/)
3. [20. 有效的括号 简单](https://leetcode.cn/problems/valid-parentheses/)
4. [剑指 Offer 31. 栈的压入、弹出序列 中等](https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)
   
#### 队列/双向队列

1. [剑指 Offer 59 - I. 滑动窗口的最大值 困难](https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)
2. [面试题59 - II. 队列的最大值 中等](https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/): 和上一题思想一致

#### 堆

- Top K问题、求中位数或中位数变体(99值问题)

1. [剑指 Offer 40. 最小的k个数 简单](https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/): 大顶堆
2. [215. 数组中的第K个最大元素 中等](https://leetcode.cn/problems/kth-largest-element-in-an-array/): 小顶堆
3. [703. 数据流中的第 K 大元素 简单](https://leetcode.cn/problems/kth-largest-element-in-a-stream/): 小顶堆
4. [剑指 Offer 41. 数据流中的中位数 困难](https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/): 中位数问题用两个堆根本不难

### 12. 字符串

1. [165. 比较版本号 中等](https://leetcode.cn/problems/compare-version-numbers/)
2. [14. 最长公共前缀 简单](https://leetcode.cn/problems/longest-common-prefix/)
3. [43. 字符串相乘 中等](https://leetcode.cn/problems/multiply-strings/)
4. [剑指 Offer 05. 替换空格 简单](https://leetcode.cn/problems/ti-huan-kong-ge-lcof/)
5. [8. 字符串转换整数 (atoi) 中等](https://leetcode.cn/problems/string-to-integer-atoi/)
6. [151. 反转字符串中的单词 中等](https://leetcode.cn/problems/reverse-words-in-a-string/)

### 13. 位运算

1. [剑指 Offer 15. 二进制中1的个数 简单](https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)
2. [剑指 Offer 16. 数值的整数次方 中等](https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)
3. [50. Pow(x, n) 中等](https://leetcode.cn/problems/powx-n/)
4. [137. 只出现一次的数字 II 中等](https://leetcode.cn/problems/single-number-ii/)

### 14. 排序算法

1. [冒泡排序](https://www.hello-algo.com/chapter_sorting/bubble_sort/)
2. [插入排序](https://www.hello-algo.com/chapter_sorting/insertion_sort/)
3. [快速排序](https://www.hello-algo.com/chapter_sorting/quick_sort/)
4. [剑指 Offer 51. 数组中的逆序对 困难](https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/): 归并排序

### 15. 其他

1. [面试题45. 把数组排成最小的数 中等](https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/): 自定义排序
2. [面试题61. 扑克牌中的顺子 简单](https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)
3. [146. LRU 缓存 中等](https://leetcode.cn/problems/lru-cache/)
4. [240. 搜索二维矩阵 II 中等](https://leetcode.cn/problems/search-a-2d-matrix-ii/)

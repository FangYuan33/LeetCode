package leetcode.binaryindexedtree;

import java.util.*;

public class Solution {
    /*
树状数组模板
 */
    int idx = 0;    // 树状数组索引
    int[] tr = new int[3 * 100010]; // 树状数组节点(数目等于元素坑位数)

    int lowBit(int x) {
        return x & -x;
    }

    // 往u坑位加上x
    void add(int u, int x) {
        for (int i = u; i <= idx; i += lowBit(i)) {
            tr[i] += x;
        }
    }

    // 查询[1,x]前缀和
    int query(int u) {
        int res = 0;
        for (int i = u; i > 0; i -= lowBit(i)) {
            res += tr[i];
        }
        return res;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        /*
        离散化+树状数组:
        题目原意:给定数组nums,寻找nums中区间和在[lower,upper]的区间sum[i,j]个数
        设当前区间区间为[i,j],移动j指针,我们只需要的求出每个以j结尾的区间有多少个是区间和在[lower,upper]即可
        朴素的解法中我们可以扫描k∈[0,i-1],求适合的k有多少个,时间复杂度综合为O(N^2)

        逆向思维,我们把目光放在[0,k]区间上,设sum[0,i]=sum[0,k]+sum[k+1,i]=s
        其中 lower<=sum[k+1,i]<=upper --> lower<=s-sum[0,k]<=upper --> s-upper<=sum[0,k]<=s-lower
        我们把问题就转化为了求在[0,i-1]区间内前缀和为[s-upper,s-lower]的个数

        求前缀和"个数",同时前缀和的值域范围爆炸,我们把可能出现的前缀和直接离散化分散到特定数据结构
        然后统计[s-upper,s-lower]范围内的前缀和个数可以抽象成 前面前缀和出现了就在对应坑位数目+1 ,然后再进行区间求和
        此处要想在O(logN)内求出某个区间的和(前缀和作差得到)就要用到树状数组
        前缀和可能出现的情况数目为:3*1e5
        总体时间复杂度:O(NlogN) 空间复杂度:O(N)
         */
        // 将前缀和进行去重
        HashSet<Long> set = new HashSet<>();    // 存储可能出现的前缀和
        long preSum = 0L;
        set.add(0L);
        for (int num : nums) {
            preSum += num;
            set.add(preSum);
            set.add(preSum - upper);
            set.add(preSum - lower);
        }
        // 排序并离散化
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        HashMap<Long, Integer> map = new HashMap<>();   // 存储某个前缀和对应的索引
        for (long sum : list) map.put(sum, ++idx);   // 树状数组索引从1开始

        preSum = 0L;
        add(map.get(preSum), 1);    // 初始化前缀和为0的坑位+1

        int res = 0;
        for (int num : nums) {
            preSum += num;
            // a 为前缀和preSum-lower对应坑位; b 为前缀和preSum-upper对应坑位
            int a = map.get(preSum - lower), b = map.get(preSum - upper);
            res += query(a) - query(b - 1); // 累加[preSum-upper,preSum-lower]前缀和个数
            // 记得是先求完前缀和个数再更新,保证树状数组是[0,i-1]状态下的
            add(map.get(preSum), 1);
        }

        return res;
    }
}

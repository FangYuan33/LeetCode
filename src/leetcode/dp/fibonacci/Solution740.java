package leetcode.dp.fibonacci;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution740 {

    /**
     * 给你一个整数数组 nums ，你可以对它进行一些操作。
     * <p>
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
     * <p>
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,2]
     * 输出：6
     * 解释：
     * 删除 4 获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,3,3,3,4]
     * 输出：9
     * 解释：
     * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
     * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
     * 总共获得 9 个点数。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2 * 104
     * 1 <= nums[i] <= 104
     */

    public static void main(String[] args) {
        System.out.println(new Solution740().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(new Solution740().deleteAndEarn(new int[]{3, 4, 2}));
    }

    /**
     * 打家劫舍 前后都不能动的版本
     */
    public int deleteAndEarn(int[] nums) {
        // 保存所有数字的数量
        int[] nums2 = new int[(int) (1e4 + 1)];
        for (int num : nums) {
            nums2[num]++;
        }

        int[] dp = new int[nums2.length + 2];
        for (int i = 1; i < nums2.length; i++) {
            // 偷 / 不偷
            dp[i + 2] = Math.max(i * nums2[i] + dp[i], dp[i + 1]);
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }

}

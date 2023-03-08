package leetcode.doublepointer;

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        // 记录字符需要的数量
        int[] needCharCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            needCharCount[t.charAt(i)]++;
        }

        // 还需要再匹配的字符数
        int count = t.length();

        String res = "";
        int resLength = -1;
        // 滑动窗口初始化
        int left = 0, right = 0;

        while (right < s.length()) {
            // 如果当前字符匹配的话
            if (needCharCount[s.charAt(right)] > 0) {
                count--;
            }
            // 窗口右边界进入窗口
            needCharCount[s.charAt(right)]--;

            // 如果已经匹配好了
            if (count == 0) {
                // 看看能不能缩小窗口
                while (needCharCount[s.charAt(left)] < 0) {
                    needCharCount[s.charAt(left)]++;
                    left++;
                }

                // 左窗口不能再缩小了那么可以看下结果了
                if (resLength == -1) {
                    resLength = right - left + 1;
                    res = s.substring(left, right + 1);
                } else {
                    if (right - left + 1 < resLength) {
                        resLength = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                }

                // 统计完本次需要移动窗口造成不匹配的情况继续移动
                needCharCount[s.charAt(left)]++;
                left++;
                count++;
            }

            // 移动右侧窗口来去构建匹配条件
            right++;
        }

        return res;
    }
}

package leetcode.dp;

public class Solution467 {

    public static void main(String[] args) {
        System.out.println(new Solution467().findSubstringInWraproundString("zab"));
    }

    public int findSubstringInWraproundString(String s) {
        char[] charArray = s.toCharArray();
        // 记录每个索引位置的字符作为子串最后一个元素能形成的符合条件的数量
        int[] max = new int[26];
        // 记录第一个字符
        max[charArray[0] - 'a'] += 1;
        // 默认最少为 1 个字符形成的子串
        int num = 1;

        for (int i = 1; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            int preIndex = charArray[i - 1] - 'a';

            // 如果与前一个字符是连号 或 za 连号的话
            if (index == preIndex + 1 || preIndex == 25  && index == 0) {
                num++;
            } else {
                // 打破连号的话，需要从 1 再开始记
                num = 1;
            }

            // 取最大值
            max[index] = Math.max(num, max[index]);
        }
        // 封装结果值
        int res = 0;
        for (int i : max) {
            res += i;
        }

        return res;
    }
}

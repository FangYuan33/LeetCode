package leetcode.simulate;

public class Solution400 {

    public static void main(String[] args) {
        System.out.println(new Solution400().findNthDigit(11));
    }

    public int findNthDigit(int n) {
        // 计算出它在哪个组
        int row = 1;
        while (n > Math.pow(10, row - 1) * 9 * row) {
            n -= Math.pow(10, row - 1) * 9 * row;
            row++;
        }
        // 计算它是第几个数字
        int count = n % row == 0 ? n / row : n / row + 1;
        // 是多少
        String num = String.valueOf((long) (Math.pow(10, row - 1) + count - 1));
        // 从头向后偏
        long step = n % row;
        return step == 0 ? num.charAt(num.length() - 1) - '0' : num.charAt((int) (step - 1)) - '0';
    }
}

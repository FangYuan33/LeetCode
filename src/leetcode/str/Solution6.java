package leetcode.str;

public class Solution6 {

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }
        boolean down = true;
        int index = 0;
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            builders[index].append(c);
            if (down) {
                index++;
                if (index == builders.length) {
                    down = !down;
                    index -= 2;
                }
            } else {
                index--;
                if (index == -1) {
                    down = !down;
                    index += 2;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builders) {
            res.append(builder);
        }

        return res.toString();
    }
}

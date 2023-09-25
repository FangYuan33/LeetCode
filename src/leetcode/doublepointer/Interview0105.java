package leetcode.doublepointer;

public class Interview0105 {

    public static void main(String[] args) {
        System.out.println(new Interview0105().oneEditAway("ab", "bc"));
    }

    public boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        if (first.length() - second.length() > 1) {
            return false;
        }
        int count = 0;
        int f = 0, s = 0;
        while (f < first.length() && s < second.length()) {
            // 相等长度是替换
            if (first.charAt(f) == second.charAt(s)) {
                f++;
                s++;
            } else {
                // 大长度则是删除
                if (first.length() - f > second.length() - s) {
                    f++;
                    count++;
                } else {
                    f++;
                    s++;
                    count++;
                }
            }
        }

        return count <= 1;
    }
}

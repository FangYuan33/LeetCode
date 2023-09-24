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
        while (s < second.length() && f < first.length()) {
            if (first.charAt(f) == second.charAt(s)) {
                f++;
                s++;
            } else {
                if (first.length() == second.length()) {
                    f++;
                    s++;
                    count++;
                } else {
                    f++;
                    count++;
                }
            }
        }

        return count <= 1;
    }
}

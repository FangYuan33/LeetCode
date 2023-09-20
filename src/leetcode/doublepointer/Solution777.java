package leetcode.doublepointer;

public class Solution777 {

    public static void main(String[] args) {
        System.out.println(new Solution777().canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }

    public boolean canTransform(String start, String end) {
        int left, right = 0;
        while (right < start.length()) {
            while (right < start.length() && start.charAt(right) == end.charAt(right)) {
                right++;
            }
            if (right < start.length() && start.charAt(right) != end.charAt(right)) {
                left = right;
                if (left + 1 < start.length()) {
                    right += 2;
                    String s = start.substring(left, right);
                    String e = end.substring(left, right);
                    char one = s.charAt(0), two = s.charAt(1);

                    if (e.contains(String.valueOf(one)) && e.contains(String.valueOf(two))) {
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        return right == start.length();
    }
}

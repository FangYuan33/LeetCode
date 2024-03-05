package leetcode.simulate;

public class Solution796 {

    public boolean rotateString(String s, String goal) {
        StringBuilder origin = new StringBuilder(s);
        int index = 0;
        while (index < origin.length()) {
            if (origin.toString().equals(goal)) {
                return true;
            } else {
                char c = origin.charAt(0);
                origin.deleteCharAt(0);
                origin.append(c);
            }
            index++;
        }

        return false;
    }

}

package leetcode.doublepointer;

public class Interview0105 {

    public static void main(String[] args) {
        // false
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
        int fIndex = 0, sIndex = 0;
        while (fIndex < first.length() && sIndex < second.length()) {
            if (first.charAt(fIndex) == second.charAt(sIndex)) {
                fIndex++;
                sIndex++;
            } else {
                // 不等长选择删除策略，等长选择替换策略
                if (first.length() - fIndex > second.length() - sIndex) {
                    fIndex++;
                } else {
                    fIndex++;
                    sIndex++;
                }
                count++;
            }
        }

        return count <= 1;
    }
}

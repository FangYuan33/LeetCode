package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution937 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution937().reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can",
                "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }

    static class Log implements Comparable<Log> {

        /**
         * 标识符
         */
        String flag;

        /**
         * 0-字母日志 1-数字日志
         */
        int type;

        /**
         * 除标识符外的内容
         */
        String content;

        /**
         * 原内容
         */
        String origin;

        @Override
        public int compareTo(Log o) {
            if (this.type == 1 && o.type == 1) {
                return 0;
            } else if (this.type == 0 && o.type == 1) {
                return -1;
            } else if (this.type == 1 && o.type == 0) {
                return 1;
            } else {
                if (this.content.equals(o.content)) {
                    return this.flag.compareTo(o.flag);
                } else {
                    return this.content.compareTo(o.content);
                }
            }
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        ArrayList<Log> list = new ArrayList<>(logs.length);
        for (String log : logs) {
            Log element = new Log();
            element.origin = log;
            String[] s = log.split(" ");
            element.flag = s[0];
            if (Character.isDigit(s[1].charAt(0))) {
                element.type = 1;
            }
            String content = Arrays.toString(Arrays.copyOfRange(s, 1, s.length));
            element.content = content.substring(1, content.length() - 1);

            list.add(element);
        }
        Collections.sort(list);

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).origin;
        }

        return res;
    }
}

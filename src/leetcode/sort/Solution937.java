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
         * 0: 字母; 1: 数字
         */
        int type;

        String flag;

        String content;

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
                if (content.equals(o.content)) {
                    return flag.compareTo(o.flag);
                } else {
                    return content.compareTo(o.content);
                }
            }
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        ArrayList<Log> list = new ArrayList<>(logs.length);
        for (String value : logs) {
            Log log = new Log();
            String[] s = value.split(" ");
            log.flag = s[0];
            log.origin = value;
            if (Character.isDigit(s[1].charAt(0))) {
                log.type = 1;
            }
            String content = Arrays.toString(Arrays.copyOfRange(s, 1, s.length));
            log.content = content.substring(1, content.length() - 1);

            list.add(log);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            logs[i] = list.get(i).origin;
        }

        return logs;
    }
}

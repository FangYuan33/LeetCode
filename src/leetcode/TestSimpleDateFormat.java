package leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 验证SimpleDateFormat是线程不安全的
 */
public class TestSimpleDateFormat {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Date now = new Date();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    String format1 = dateFormat.format(now);
                    Date parse1 = dateFormat.parse(format1);
                    String format2 = dateFormat.format(parse1);

                    // 理论上format1和format2是一样的
                    System.out.println(format2.equals(format1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}

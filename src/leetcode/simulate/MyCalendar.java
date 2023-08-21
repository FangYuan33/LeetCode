package leetcode.simulate;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        myCalendar.book(10, 20);
        myCalendar.book(15, 25);
    }

    List<int[]> calendarDate;

    public MyCalendar() {
        calendarDate = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] date : calendarDate) {
            int left = date[0], right = date[1];

            if (start >= right || end <= left) {
                continue;
            }
            return false;
        }
        calendarDate.add(new int[]{start, end});

        return true;
    }
}

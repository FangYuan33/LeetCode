package leetcode.doublepointer;

import java.util.Arrays;

public class Solution881 {

    public static void main(String[] args) {
        // 3
        System.out.println(new Solution881().numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        int left = 0, right = people.length - 1;
        Arrays.sort(people);

        while (left <= right) {
            int curPeople = 0;
            int curWeight = 0;
            while (curPeople < 2 && left <= right && curWeight + people[right] <= limit) {
                curWeight += people[right--];
                curPeople++;
            }
            while (curPeople < 2 && left <= right && curWeight + people[left] <= limit) {
                curWeight += people[left++];
                curPeople++;
            }
            res++;
        }

        return res;
    }
}

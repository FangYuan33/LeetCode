package leetcode.doublepointer;

import java.util.Arrays;

public class Solution881 {

    public static void main(String[] args) {
        System.out.println(new Solution881().numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int res = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int peopleNum = 0;
            int cur = 0;
            while (left <= right && cur + people[right] <= limit && peopleNum < 2) {
                cur += people[right];
                right--;
                peopleNum++;
            }
            while (left <= right && cur + people[left] <= limit && peopleNum < 2) {
                cur += people[left];
                left++;
                peopleNum++;
            }
            res++;
        }

        return res;
    }
}

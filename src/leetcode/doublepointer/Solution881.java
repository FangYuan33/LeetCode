package leetcode.doublepointer;

import java.util.Arrays;

public class Solution881 {

    public static void main(String[] args) {
        // 3
        System.out.println(new Solution881().numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int res = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int weight = 0;
            int peopleNum = 0;
            while (left <= right && weight + people[right] <= limit && peopleNum < 2) {
                peopleNum++;
                weight += people[right--];
            }
            while (left <= right && weight + people[left] <= limit && peopleNum < 2) {
                peopleNum++;
                weight += people[left++];
            }
            res++;
        }

        return res;
    }
}

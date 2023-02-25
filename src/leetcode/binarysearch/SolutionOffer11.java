package leetcode.binarysearch;

public class SolutionOffer11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] > numbers[right]) {
                // 落在了大区间
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 落在了小区间
                right = mid;
            } else {
                right--;
            }
        }

        return numbers[left];
    }
}

package leetcode.sort;

public class Interview1714 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];

        for (int i = 0; i < arr.length; i++) {
            if (k == 0) {
                break;
            }

            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            res[--k] = arr[min];
            swap(arr, min, i);
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

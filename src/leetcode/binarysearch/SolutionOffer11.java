package leetcode.binarysearch;

public class SolutionOffer11 {
    public int minArray(int[] numbers) {
        // 寻找数据的两段性
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] > numbers[right]) {
                // 落在了大区间
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 落在了小区间
                right = mid;
            } else {
                // 不知道是落在了大区间还是小区间，答案可能在中值左边也可能在右边
                // 而且一定存在 [left, mid] 都相等 或 [mid, right] 的值都相等
                // 前者都相等的话，答案出现在右边儿；后者相等的话，答案在左边儿 那么答案一定在[left, right]这个区间内
                // 以left为索引执行线性遍历找到这个值即可
                int index = left;

                for (int i = index + 1; i < right; i++) {
                    if (numbers[i] < numbers[index]) {
                        index = i;
                    }
                }

                return numbers[index];
            }
        }

        return numbers[right];
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer11().minArray(new int[]{3, 3, 1, 3}));
    }
}

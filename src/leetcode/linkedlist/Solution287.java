package leetcode.linkedlist;

public class Solution287 {

    public static void main(String[] args) {
        System.out.println(new Solution287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // 第一次相遇，已经在环形链表中
        do {
            slow = next(nums, slow);
            fast = next(nums, next(nums, fast));
        } while (slow != fast);
        // 头节点从 0 开始走，与 slow 相遇即是环的入口，该入口被多个节点指向
        int head = 0;
        while (slow != head) {
            slow = next(nums, slow);
            head = next(nums, head);
        }

        // 那么slow即为指向该入口的重复元素之一
        return slow;
    }

    private int next(int[] nums, int i) {
        return nums[i];
    }
}

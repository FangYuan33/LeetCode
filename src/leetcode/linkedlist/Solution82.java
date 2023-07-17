package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 把重复的前驱节点也记录下来，删除节点的时候使用
        ListNode preHead = pre;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                // 碰见重复的一直删除
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }

                // 删除完毕后把这个节点也删除
                preHead.next = head.next;
                head = preHead.next;
            } else {
                // 不重复的变换指针即可
                head = head.next;
                preHead = preHead.next;
            }
        }

        return pre.next;
    }
}

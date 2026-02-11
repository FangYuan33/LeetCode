package leetcode;

import leetcode.utils.ListNodeUtil;

import java.util.*;

/**
 * 供本地题解使用
 *
 * @author FangYuan
 * @since 2023-11-14 09:26:23
 */
public class Solution {

    public static void main(String[] args) {
        ListNode x = ListNodeUtil.generate(new int[]{3, 2, 0, -4});

        System.out.println(new Solution().detectCycle(x));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        HashSet<ListNode> nodes = new HashSet<>();
        ListNode slow = pre, fast = pre;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 有环
            if (slow == fast) {
                while (!nodes.contains(slow)) {
                    nodes.add(slow);
                    slow = slow.next;
                }
                break;
            }
        }

        if (!nodes.isEmpty()) {
            while (true) {
                if (nodes.contains(pre.next)) {
                    return pre.next;
                }
                pre = pre.next;
            }
        } else {
            return null;
        }
    }

}

package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution725 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node2.next = node3;
        node1.next = node2;

        new Solution725().splitListToParts(node1, 5);
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        // k 组
        ListNode[] res = new ListNode[k];
        if (head == null) {
            return res;
        }

        // 总长度
        int length = getLength(head);
        // 每组分几个
        int group = length / k;
        // 前几个多分 1 个
        int num = length % k;

        // 遍历分组
        for (int i = 0; i < res.length; i++) {
            // 前驱节点用于删除节点
            ListNode pre = new ListNode(-1);
            pre.next = head;
            int currentGroup = group;
            if (num > 0) {
                currentGroup++;
                num--;
            }
            if (currentGroup == 0) {
                continue;
            }

            res[i] = head;
            while (currentGroup != 0) {
                pre = pre.next;
                head = head.next;
                currentGroup--;
            }
            // 执行节点连接断开
            pre.next = null;
            pre = head;
        }

        return res;
    }

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }
}

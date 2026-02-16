package leetcode.utils;

import leetcode.ListNode;

public class ListNodeUtil {

    public static ListNode generate(int[] listNodes) {
        if (listNodes == null || listNodes.length == 0) {
            return null;
        }
        
        // 创建头节点
        ListNode head = new ListNode(listNodes[0]);
        ListNode current = head;
        
        // 依次创建后续节点
        for (int i = 1; i < listNodes.length; i++) {
            current.next = new ListNode(listNodes[i]);
            current = current.next;
        }
        
        return head;
    }

}

package leetcode.tree.bst;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        return build(nodes, 0, nodes.size() - 1);
    }

    private TreeNode build(List<ListNode> nodes, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + right >> 1;
        TreeNode node = new TreeNode(nodes.get(mid).val);
        node.left = build(nodes, left, mid - 1);
        node.right = build(nodes, mid + 1, right);

        return node;
    }
}

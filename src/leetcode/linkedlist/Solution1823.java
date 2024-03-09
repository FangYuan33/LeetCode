package leetcode.linkedlist;

import java.util.LinkedList;

public class Solution1823 {

    public static void main(String[] args) {
        System.out.println(new Solution1823().findTheWinner(5, 2));
    }

    public int findTheWinner(int n, int k) {
        LinkedList<Integer> children = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }

        int cur = 0;
        while (children.size() > 1) {
            int index = cur + k - 1 < children.size() ? cur + k - 1 : (cur + k - 1) % children.size();
            children.remove(index);
            cur = index;
        }

        return children.peek();
    }
}

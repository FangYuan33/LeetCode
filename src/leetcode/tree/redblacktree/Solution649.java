package leetcode.tree.redblacktree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Solution649 {

    public static void main(String[] args) {
        // Radiant
        System.out.println(new Solution649().predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        char[] charArray = senate.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'D') {
                dQueue.offer(i);
            } else {
                rQueue.offer(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            Integer r = rQueue.poll();
            Integer d = dQueue.poll();

            if (r < d) {
                rQueue.offer(r + senate.length());
                charArray[d % charArray.length] = 'x';
            } else {
                dQueue.offer(d + senate.length());
                charArray[r % charArray.length] = 'x';
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }

}

package leetcode.binarysearch;

import java.util.HashMap;

public class TopVotedCandidate {

    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(
                new int[]{0,0,0,0,1},
                new int[]{0,6,39,52,75}
        );

        System.out.println(candidate.q(45));
        System.out.println(candidate.q(49));
        System.out.println(candidate.q(59));
        System.out.println(candidate.q(68));
        System.out.println(candidate.q(42));
        System.out.println(candidate.q(37));
        System.out.println(candidate.q(99));
    }

    int[] times;

    int[] result;

    HashMap<Integer, Integer> personVote;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        result = new int[persons.length];
        personVote = new HashMap<>();
        int curPerson = -1;

        for (int i = 0; i < persons.length; i++) {
            int vote = personVote.getOrDefault(persons[i], 0) + 1;
            personVote.put(persons[i], vote);

            if (vote >= personVote.getOrDefault(curPerson, 0)) {
                curPerson = persons[i];
            }
            result[i] = curPerson;
        }
    }

    public int q(int t) {
        int left = 0, right = times.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (times[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return result[--left];
    }
}

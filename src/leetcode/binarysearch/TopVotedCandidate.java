package leetcode.binarysearch;

import java.util.HashMap;

public class TopVotedCandidate {

    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(
                new int[]{0, 0, 0, 0, 1},
                new int[]{0, 6, 39, 52, 75}
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

    HashMap<Integer, Integer> timePerson;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.timePerson = new HashMap<>();
        HashMap<Integer, Integer> personVotes = new HashMap<>();
        int maxVote = 0, currentPerson = -1;
        for (int i = 0; i < times.length; i++) {
            int v = persons[i];
            int votes = personVotes.getOrDefault(v, 0) + 1;
            if (votes >= maxVote) {
                maxVote = votes;
                currentPerson = v;
            }
            timePerson.put(times[i], currentPerson);
            personVotes.put(v, votes);
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

        return timePerson.get(times[left - 1]);
    }
}

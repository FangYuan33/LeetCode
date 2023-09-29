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

    HashMap<Integer, Integer> timeIndexPeople;

    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        timeIndexPeople = new HashMap<>(times.length);

        int[] personsVotes = new int[persons.length];
        int maxVote = 0;
        int currentPerson = -1;
        for (int i = 0; i < times.length; i++) {
            personsVotes[persons[i]]++;
            if (personsVotes[persons[i]] >= maxVote) {
                maxVote = personsVotes[persons[i]];
                currentPerson = persons[i];
            }
            timeIndexPeople.put(i, currentPerson);
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

        return timeIndexPeople.get(left - 1);
    }
}

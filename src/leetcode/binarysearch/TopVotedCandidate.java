package leetcode.binarysearch;

import java.util.HashMap;

public class TopVotedCandidate {

    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});

        System.out.println(candidate.q(5));
    }

    int[] persons;

    int[] times;

    int[] result;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.result = new int[times.length];

        // 唱票
        int max = 0, person = -1;
        HashMap<Integer, Integer> personVote = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            personVote.put(persons[i], personVote.getOrDefault(persons[i], 0) + 1);

            Integer vote = personVote.get(persons[i]);
            if (vote >= max) {
                person = persons[i];
                max = vote;
            }
            result[i] = person;
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

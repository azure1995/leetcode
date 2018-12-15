class TopVotedCandidate {
    int maxVotes;
    Map<Integer, Integer> map;
    int[] record;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        int N = persons.length;
        this.maxVotes = 0;
        this.map = new HashMap<>();
        this.record = new int[N];
        this.times = times;
        for (int i = 0; i < N; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= maxVotes) {
                record[i] = persons[i];
                maxVotes = map.get(persons[i]);
            } else {
                record[i] = i == 0 ? persons[0] : record[i - 1];
            }
        }
    }

    public int q(int t) {
        int index = Arrays.binarySearch(times, t);
        index = index < 0 ? -index - 2 : index;
        return record[index];
    }
}


/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
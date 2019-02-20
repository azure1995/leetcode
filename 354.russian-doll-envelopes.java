class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int index = Collections.binarySearch(list, envelopes[i][1]);
            if (index >= 0) continue;
            index = -index - 1;
            if (index == list.size()) {
                list.add(envelopes[i][1]);
            } else {
                list.set(index, envelopes[i][1]);
            }
        }
        return list.size();
    }
}
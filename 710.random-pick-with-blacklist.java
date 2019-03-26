import java.util.List;

class Solution {
    List<int[]> ranges = new ArrayList<>();
    List<Integer> sums = new ArrayList<>();
    int sum = 0;

    public Solution(int N, int[] blacklist) {
        Arrays.sort(blacklist);
        if (blacklist.length == 0) {
            ranges.add(new int[] { 0, N - 1 });
            sums.add(N);
        } else {
            for (int i = 0; i <= blacklist.length; i++) {
                int[] range = new int[] { i == 0 ? 0 : blacklist[i - 1] + 1,
                        i == blacklist.length ? N - 1 : blacklist[i] - 1 };
                if (range[1] >= range[0]) {
                    ranges.add(range);
                    sum += range[1] - range[0] + 1;
                    sums.add(sum);
                }
                while (i + 1 < blacklist.length
                        && (blacklist[i] == blacklist[i + 1] || blacklist[i] + 1 == blacklist[i + 1])) {
                    i++;
                }
            }
        }

    }

    public int pick() {
        int p = (int) (Math.random() * sum);
        int i = Collections.binarySearch(sums, p);
        i = i >= 0 ? i + 1 : -i - 1;
        return ranges.get(i)[0] + (int) (Math.random() * (ranges.get(i)[1] - ranges.get(i)[0] + 1));
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(N, blacklist); int param_1 = obj.pick();
 */

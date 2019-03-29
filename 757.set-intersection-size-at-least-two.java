class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        LinkedList<int[]> lists = new LinkedList<>();
        for (int[] interval : intervals) {
            if (!lists.isEmpty() && interval[0] == lists.get(lists.size() - 1)[0]) {
                continue;
            } else {
                while (!lists.isEmpty() && interval[1] <= lists.get(lists.size() - 1)[1]) {
                    lists.pollLast();
                }
                lists.offerLast(interval);
            }
        }
        int ans = 0;
        int[] pick = new int[] { -1, -1 };
        for (int[] interval : lists) {
            if (pick[1] < interval[0]) {
                ans += 2;
                pick[0] = interval[1] - 1;
                pick[1] = interval[1];
            } else if (pick[1] == interval[0]) {
                ans += 1;
                pick[0] = interval[0];
                pick[1] = interval[1];
            } else if (pick[1] > interval[0] && pick[0] < interval[0]) {
                ans += 1;
                pick[0] = pick[1];
                pick[1] = interval[1];
            }
        }
        return ans;
    }
}

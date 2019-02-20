class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int N = Profits.length;
        int[][] comb = new int[N][];
        for (int i = 0; i < N; i++) {
            comb[i] = new int[] { Capital[i], Profits[i] };
        }
        Arrays.sort(comb, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a > b ? -1 : 1);
        int ci = 0;
        for (int i = 0; i < k; i++) {
            while (ci < N && comb[ci][0] <= W) {
                pq.offer(comb[ci][1]);
                ci++;
            }
            Integer p = pq.poll();
            if (p == null) {
                break;
            }
            W += p;
        }
        return W;
    }
}
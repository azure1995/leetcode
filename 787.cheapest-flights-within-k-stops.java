class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
        int[][] travels = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            travels[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        int[] costs = new int[n];
        Arrays.fill(costs, -1);
        costs[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] copy = costs.clone();
            for (int j = 0; j < n; j++) {
                if (copy[j] == -1) continue;
                for (int s = 0; s < n; s++) {
                    if (travels[j][s] == 0) continue;
                    costs[s] = Math.min(costs[s] == -1 ? Integer.MAX_VALUE : costs[s], copy[j] + travels[j][s]);
                }
            }
        }
        return costs[dst];
    }
}

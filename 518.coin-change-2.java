class Solution {
    public int change(int amount, int[] coins) {
        int[][] record = new int[2][amount + 1];
        record[0][0] = record[1][0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > amount) {
                continue;
            }
            record[i % 2] = record[(i + 1) % 2].clone();
            for (int j = 1; j <= amount / coins[i]; j++) {
                for (int t = amount; t >= j * coins[i]; t--) {
                    record[i % 2][t] += record[(i + 1) % 2][t - j * coins[i]];
                }
            }
        }
        return record[0][amount];
    }
}
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int counter = 0;
        int maxLen = 1;
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (dp[i][0] == maxLen) {
                counter += dp[i][1];
            } else if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                counter = dp[i][1];
            }
        }
        return counter;
    }
}
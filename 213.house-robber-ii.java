<<<<<<< HEAD
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[][] dp = new int[2][nums.length - 1];
        int[] preMax = new int[2];
        for (int i = 0; i < 2; i++) {
            preMax[i] = dp[i][0] = nums[i];
            dp[i][1] = nums[i + 1];
        }
        for (int i = 2; i < nums.length - 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[j][i] = Math.max(dp[j][i - 1], preMax[j] + nums[i + j]);
                preMax[j] = Math.max(preMax[j], dp[j][i - 1]);
            }
        }
        return Math.max(Math.max(dp[0][nums.length - 2], preMax[0]), Math.max(dp[1][nums.length - 2], preMax[1]));
    }
=======
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[][] dp = new int[2][nums.length - 1];
        int[] preMax = new int[2];
        for (int i = 0; i < 2; i++) {
            preMax[i] = dp[i][0] = nums[i];
            dp[i][1] = nums[i + 1];
        }
        for (int i = 2; i < nums.length - 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[j][i] = Math.max(dp[j][i - 1], preMax[j] + nums[i + j]);
                preMax[j] = Math.max(preMax[j], dp[j][i - 1]);
            }
        }
        return Math.max(Math.max(dp[0][nums.length - 2], preMax[0]), Math.max(dp[1][nums.length - 2], preMax[1]));
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}
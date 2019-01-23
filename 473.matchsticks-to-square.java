import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] nums) {
        int len = nums.length;
        if (len < 4) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 > 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / 4;
        boolean[] dp = new boolean[1 << len];
        dp[0] = true;
        int[] total = new int[1 << len];
        for (int state = 0; state < 1 << len; state++) {
            if (!dp[state]) continue;
            for (int j = 0; j < len; j++) {
                int future = state | (1 << j);
                if ((state & (1 << j)) == 0) {
                    if (nums[j] <= target - (total[state] % target)) {
                        dp[future] = true;
                        total[future] = total[state] + nums[j];
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[(1 << len) - 1];
    }
}
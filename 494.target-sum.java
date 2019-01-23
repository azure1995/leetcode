class Solution {
    final int sumMax = 1000;

    public int findTargetSumWays(int[] nums, int S) {
        int[] restSums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            restSums[i] = i == nums.length - 1 ? nums[i] : restSums[i + 1] + nums[i];
        }
        if (restSums[0] < Math.abs(S)) {
            return 0;
        }
        S += sumMax;
        int[][] record = new int[2][2 * sumMax + 1];
        record[0][1000] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = Math.max(0, S - restSums[i - 1]); j <= Math.min(2 * sumMax, S + restSums[i - 1]); j++) {
                record[i % 2][j] = 0;
                if (j - nums[i - 1] >= 0)
                    record[i % 2][j] += record[(i - 1) % 2][j - nums[i - 1]];
                if (j + nums[i - 1] <= 2 * sumMax)
                    record[i % 2][j] += record[(i - 1) % 2][j + nums[i - 1]];
            }
        }
        return record[nums.length % 2][S];
    }
}
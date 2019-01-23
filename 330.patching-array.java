class Solution {
    public int minPatches(int[] nums, int n) {
        long m = 1;
        int i = 0, ret = 0;
        while (m <= n) {
            if (i == nums.length || m < nums[i]) {
                m += m;
                ret++;
            } else {
                m += nums[i];
                i++;
            }
        }
        return ret;
    }
}
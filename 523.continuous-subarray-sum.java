class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int acc = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (k == 0) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            } else {
                if (nums[i] % k == 0 && nums[i + 1] % k == 0) {
                    return true;
                }
            }
            if (k > 0 && set.contains((acc + nums[i] + nums[i + 1]) % k)) {
                return true;
            }
            acc += nums[i];
            acc = k > 0 ? acc % k : acc;
            set.add(acc);
        }
        return false;
    }
}
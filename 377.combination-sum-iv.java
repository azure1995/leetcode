<<<<<<< HEAD
class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] re = new int[target + 1];
        re[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    re[i] += re[i - nums[j]];
                }
            }
        }
        return re[target];
    }
=======
class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] re = new int[target + 1];
        re[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    re[i] += re[i - nums[j]];
                }
            }
        }
        return re[target];
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}
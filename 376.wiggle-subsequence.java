<<<<<<< HEAD
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int inflectNum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] - nums[i - 1]) * (nums[i + 1] - nums[i]) < 0) {
                inflectNum++;
            } else if (nums[i] - nums[i - 1] != 0 && nums[i + 1] == nums[i]) {
                int temp = nums[i] - nums[i - 1];
                while (++i + 1 < nums.length && nums[i + 1] == nums[i]);
                if (i + 1 < nums.length && temp * (nums[i + 1] - nums[i]) < 0) {
                    inflectNum++;
                }
            }
        }
        if (nums[0] == nums[nums.length - 1] && inflectNum == 0) {
            return 1;
        }
        return inflectNum + 2;
    }
=======
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int inflectNum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] - nums[i - 1]) * (nums[i + 1] - nums[i]) < 0) {
                inflectNum++;
            } else if (nums[i] - nums[i - 1] != 0 && nums[i + 1] == nums[i]) {
                int temp = nums[i] - nums[i - 1];
                while (++i + 1 < nums.length && nums[i + 1] == nums[i]);
                if (i + 1 < nums.length && temp * (nums[i + 1] - nums[i]) < 0) {
                    inflectNum++;
                }
            }
        }
        if (nums[0] == nums[nums.length - 1] && inflectNum == 0) {
            return 1;
        }
        return inflectNum + 2;
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}
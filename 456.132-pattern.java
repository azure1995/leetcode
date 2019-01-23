class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int One = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (One < nums[i]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i] && nums[j] > One) {
                        return true;
                    }
                }
            } else {
                One = nums[i];
            }
        }
        return false;
    }
}
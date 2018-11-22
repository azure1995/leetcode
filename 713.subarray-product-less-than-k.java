class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int counter = 0;
        int preNum = 0;
        int preP = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                preNum = 0;
                preP = 1;
                continue;
            }
            preP *= nums[i];
            int j = i - preNum;
            preNum++;
            while (preP >= k) {
                preP /= nums[j];
                j++;
                preNum--;
            }
            counter += preNum;
        }
        return counter;
    }
}

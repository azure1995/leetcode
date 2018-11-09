class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        int top = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE;
        while (right - left > 1) {
            if (nums[left] > bottom && nums[left] < top) {
                return true;
            }
            while (left + 1 <= right && nums[left + 1] <= nums[left]) {
                left++;
                if (nums[left] > bottom && nums[left] < top) {
                    return true;
                }
            }
            bottom = Math.min(bottom, nums[left]);
            if (nums[right] > bottom && nums[right] < top) {
                return true;
            }
            while (right - 1 >= left && nums[right - 1] >= nums[right]) {
                right--;
                if (nums[right] > bottom && nums[right] < top) {
                    return true;
                }
            }
            top = Math.max(top, nums[right]);
            if (left + 2 < nums.length && nums[left + 1] < nums[left + 2]) {
                return true;
            }
            if (right - 2 >= 0 && nums[right - 2] < nums[right - 1]) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }
}
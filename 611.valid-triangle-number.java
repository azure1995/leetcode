class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j + 1] >= nums[i] + nums[j]) continue;
                int index = Arrays.binarySearch(nums, j + 1, nums.length, nums[i] + nums[j]);
                while (index > 0 && nums[index - 1] == nums[index]) {
                    index--;
                }
                if (index < 0) {
                    index = -index - 1;
                }
                counter += index - j - 1;
            }
        }
        return counter;
    }
}
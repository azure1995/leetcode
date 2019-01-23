class Solution {
    private int binarySearch(long[] arr, long key, int d) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                if (d == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return d == 1 ? right: left;
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0 || lower > upper) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0] >= lower && nums[0] <= upper ? 1 : 0;
        }
        int mid = nums.length / 2;
        int ret = countRangeSum(Arrays.copyOfRange(nums, 0, mid), lower, upper)
                + countRangeSum(Arrays.copyOfRange(nums, mid + 1, nums.length), lower, upper);

        long[] leftSum = new long[mid];
        for (int i = mid - 1; i >= 0; i--) {
            leftSum[i] = i == mid - 1 ? nums[mid - 1] : nums[i] + leftSum[i + 1];
        }
        long[] rightSum = new long[nums.length - mid];
        for (int i = 0; i < nums.length - mid; i++) {
            rightSum[i] = i == 0 ? nums[mid] : rightSum[i - 1] + nums[i + mid];
            ret += (rightSum[i] >= lower && rightSum[i] <= upper ? 1 : 0);
        }
        Arrays.sort(leftSum);
        for (long right : rightSum) {
            int lowerIndex = binarySearch(leftSum, lower - right, -1);
            int upperIndex = binarySearch(leftSum, upper - right, 1);
            ret += (upperIndex >= lowerIndex ? upperIndex - lowerIndex + 1 : 0);
        }
        return ret;
    }
}
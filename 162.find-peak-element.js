/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function (nums) {
    let initial_len = nums.length;
    let left = 0, right = initial_len - 1;
    nums[-1] = nums[initial_len] = Number.MIN_SAFE_INTEGER;
    while (left <= right) {
        let mid = Number.parseInt((left + right) / 2);
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            delete nums[-1];
            delete nums[initial_len];
            nums.length = initial_len;
            return mid;
        } else if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
};
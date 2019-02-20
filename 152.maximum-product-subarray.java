<<<<<<< HEAD
import java.util.Arrays;

/*
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (27.63%)
 * Total Accepted:    165.5K
 * Total Submissions: 599.2K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int get(int[] subNums) {
        if (subNums.length == 1) {
            return subNums[0];
        }
        int product = 1;
        for (int num : subNums) {
            product *= num;
        }
        if (product > 0) {
            return product;
        }
        int p1 = 1;
        for (int i = 0; i < subNums.length; i++) {
            p1 *= subNums[i];
            if (subNums[i] < 0) {
                break;
            }
        }
        int p2 = 1;
        for (int i = subNums.length - 1; i >= 0; i--) {
            p2 *= subNums[i];
            if (subNums[i] < 0) {
                break;
            }
        }
        return product / Math.max(p1, p2);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end <= nums.length; end++) {
            if (end == nums.length || nums[end] == 0) {
                if (end < nums.length && nums[end] == 0) {
                    result = Math.max(result, 0);
                }
                if (end > start) {
                    result = Math.max(result, get(Arrays.copyOfRange(nums, start, end)));
                }
                while (end < nums.length && nums[end] == 0) {
                    end++;
                }
                start = end;
            }
        }
        return result;
    }
}
=======
import java.util.Arrays;

/*
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (27.63%)
 * Total Accepted:    165.5K
 * Total Submissions: 599.2K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int get(int[] subNums) {
        if (subNums.length == 1) {
            return subNums[0];
        }
        int product = 1;
        for (int num : subNums) {
            product *= num;
        }
        if (product > 0) {
            return product;
        }
        int p1 = 1;
        for (int i = 0; i < subNums.length; i++) {
            p1 *= subNums[i];
            if (subNums[i] < 0) {
                break;
            }
        }
        int p2 = 1;
        for (int i = subNums.length - 1; i >= 0; i--) {
            p2 *= subNums[i];
            if (subNums[i] < 0) {
                break;
            }
        }
        return product / Math.max(p1, p2);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end <= nums.length; end++) {
            if (end == nums.length || nums[end] == 0) {
                if (end < nums.length && nums[end] == 0) {
                    result = Math.max(result, 0);
                }
                if (end > start) {
                    result = Math.max(result, get(Arrays.copyOfRange(nums, start, end)));
                }
                while (end < nums.length && nums[end] == 0) {
                    end++;
                }
                start = end;
            }
        }
        return result;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284

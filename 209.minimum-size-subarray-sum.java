<<<<<<< HEAD
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (33.29%)
 * Total Accepted:    142.7K
 * Total Submissions: 428.7K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            queue.add(num);
            if (sum >= s) {
                do {
                    sum -= queue.remove();
                } while (sum >= s);
                result = Math.min(result, queue.size() + 1);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
=======
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (33.29%)
 * Total Accepted:    142.7K
 * Total Submissions: 428.7K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            queue.add(num);
            if (sum >= s) {
                do {
                    sum -= queue.remove();
                } while (sum >= s);
                result = Math.min(result, queue.size() + 1);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284

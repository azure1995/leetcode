import java.util.HashSet;
import java.util.Set;

/*
 * [457] Circular Array Loop
 *
 * https://leetcode.com/problems/circular-array-loop/description/
 *
 * algorithms
 * Medium (25.31%)
 * Total Accepted:    10.2K
 * Total Submissions: 40.4K
 * Testcase Example:  '[2, -1, 1, 2, 2]'
 *
 * You are given an array of positive and negative integers. If a number n at
 * an index is positive, then move forward n steps. Conversely, if it's
 * negative (-n), move backward n steps. Assume the first element of the array
 * is forward next to the last element, and the last element is backward next
 * to the first element. Determine if there is a loop in this array. A loop
 * starts and ends at a particular index with more than 1 element along the
 * loop. The loop must be "forward" or "backward'.
 * 
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0
 * -> 2 -> 3 -> 0.
 * 
 * Example 2: Given the array [-1, 2], there is no loop.
 * 
 * Note: The given array is guaranteed to contain no element "0".
 * 
 * Can you do it in O(n) time complexity and O(1) space complexity?
 * 
 */
class Solution {
    public int getNext(int i, int[] nums) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int slow = i, quick = getNext(i, nums);
            while (nums[quick] * nums[i] > 0 && nums[getNext(quick, nums)] * nums[i] > 0) {
                if (slow == quick) {
                    if (slow == getNext(slow, nums)) {
                        break;
                    }
                    return true;
                }
                slow = getNext(slow, nums);
                quick = getNext(getNext(quick, nums), nums);
            }
            int re = i;
            while (re != slow) {
                int next = getNext(re, nums);
                nums[re] = 0;
                re = next;
            }
        }
        return false;
    }

}

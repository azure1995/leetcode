/*
 * [755] Reach a Number
 *
 * https://leetcode.com/problems/reach-a-number/description/
 *
 * algorithms
 * Easy (29.12%)
 * Total Accepted:    5.3K
 * Total Submissions: 18.3K
 * Testcase Example:  '1'
 *
 * 
 * You are standing at position 0 on an infinite number line.  There is a goal
 * at position target.
 * 
 * On each move, you can either go left or right.  During the n-th move
 * (starting from 1), you take n steps.
 * 
 * Return the minimum number of steps required to reach the destination.
 * 
 * 
 * Example 1:
 * 
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * 
 * 
 * 
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 * 
 */
class Solution {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        long abs = Math.abs(target);
        int last = (int)Math.ceil(-0.5 + Math.sqrt(1+ 8 * abs)/2);
        int sum = last*(last+1)/2;
        int diff = sum - target;
        if (diff%2 == 0) {
            return last;
        } else if (last%2 == 0) {
            return last + 1;
        } else {
            return last + 2;
        }
    }
}

/*
 * [201] Bitwise AND of Numbers Range
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (34.99%)
 * Total Accepted:    72.2K
 * Total Submissions: 206.2K
 * Testcase Example:  '5\n7'
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * Example 1:
 * 
 * 
 * Input: [5,7]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1]
 * Output: 0
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int large = Math.max(m, n);
        int small = Math.min(m, n);
        String log2_large = Integer.toBinaryString(large);
        String log2_small = Integer.toBinaryString(small);
        if (log2_large.length() > log2_small.length()) {
            return 0;
        }
        int len = log2_large.length();
        int mask = 0;
        for (int i = 0; i < len; i++) {
            if (log2_large.charAt(i) != log2_small.charAt(i)) {
                break;
            }
            mask += (1 << (len - 1 - i));
        }
        return large & mask;
    }
}

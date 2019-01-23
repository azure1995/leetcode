/*
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.04%)
 * Total Accepted:    203.9K
 * Total Submissions: 969.4K
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        int[] result = new int[s.length()+1];
        result[s.length()]=1;
        result[s.length()-1]=s.charAt(s.length()-1)=='0' ? 0 : 1;
        for (int i = s.length()-2; i >= 0; i--) {
            if (result[i+1]==0 && result[i+2]==0) {
                return 0;
            }
            if (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')) {
                result[i]=result[i+1]+result[i+2];
            } else if (s.charAt(i)>'0'){
                result[i]=result[i+1];
            } 
        }
        return result[0];
    }
}

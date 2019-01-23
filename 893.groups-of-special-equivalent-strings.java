import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * [929] Groups of Special-Equivalent Strings
 *
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
 *
 * algorithms
 * Easy (61.09%)
 * Total Accepted:    6K
 * Total Submissions: 9.8K
 * Testcase Example:  '["a","b","c","a","c","c"]'
 *
 * You are given an array A of strings.
 * 
 * Two strings S and T are special-equivalent if after any number of moves, S
 * == T.
 * 
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and
 * swapping S[i] with S[j].
 * 
 * Now, a group of special-equivalent strings from A is a non-empty subset S of
 * A such that any string not in S is not special-equivalent with any string in
 * S.
 * 
 * Return the number of groups of special-equivalent strings from A.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int len = A[i].length();
            char[][] charArray = new char[2][];
            charArray[0] = new char[(len + 1)/2];
            charArray[1] = new char[len/2];
            for (int j = 0; j < len; j++) {
                charArray[j%2][j/2] = A[i].charAt(j);
            }
            Arrays.sort(charArray[0]);
            Arrays.sort(charArray[1]);
            String sorted_string = new String(charArray[0]) + new String(charArray[1]);
            set.add(sorted_string); 
        }
        return set.size();
    }
}

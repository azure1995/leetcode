import java.util.HashSet;
import java.util.Set;

/*
 * [889] Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (26.53%)
 * Total Accepted:    11.9K
 * Total Submissions: 44.7K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * Given two strings A and B of lowercase letters, return true if and only if
 * we can swap two letters in A so that the result equals B.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: A = "ab", B = "ba"
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "ab", B = "ab"
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = "aa", B = "aa"
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: A = "", B = "aa"
 * Output: false
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isDuplicate(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return true;
            }
            set.add(s.charAt(i));
        }  
        return false;
    }
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[][] diff = new char[2][2];
        int times = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (times > 1) {
                    return false;
                }
                diff[times][0] = A.charAt(i);
                diff[times][1] = B.charAt(i);
                times++;
            }
        }
        if ((times == 2 && diff[0][0] == diff[1][1] && diff[0][1] == diff[1][0])
        || times == 0 && isDuplicate(A)) {
            return true;
        } else {
            return false;
        }
    }
}

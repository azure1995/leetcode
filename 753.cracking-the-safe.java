import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=753 lang=java
 *
 * [753] Cracking the Safe
 *
 * https://leetcode.com/problems/cracking-the-safe/description/
 *
 * algorithms
 * Hard (45.12%)
 * Total Accepted:    13.1K
 * Total Submissions: 29K
 * Testcase Example:  '1\n1'
 *
 * 
 * There is a box protected by a password.  The password is n digits, where
 * each letter can be one of the first k digits 0, 1, ..., k-1.
 * 
 * You can keep inputting the password, the password will automatically be
 * matched against the last n digits entered.
 * 
 * For example, assuming the password is "345", I can open it when I type
 * "012345", but I enter a total of 6 digits.
 * 
 * Please return any string of minimum length that is guaranteed to open the
 * box after the entire string is inputted.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * 
 * 
 * 
 * Note:
 * 
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 * 
 * 
 */
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder ans = new StringBuilder();
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            start.append('0');
        }
        Set<String> seen = new HashSet<>();
        dfs(k, start.toString(), ans, seen);
        ans.append(start);
        return ans.toString();
    }

    private void dfs(int k, String start, StringBuilder ans, Set<String> seen) {
        for (int i = 0; i < k; i++) {
            String nei = start + i;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(k, nei.substring(1), ans, seen);
                ans.append(i);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/*
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (37.69%)
 * Total Accepted:    136.7K
 * Total Submissions: 362.6K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<List<String>>> result = new ArrayList<>();
        List<List<String>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        result.add(empty);
        for (int i = 1; i <= s.length(); i++) {
            List<List<String>> outer_lls = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                String sub_str = s.substring(j, i);
                if (isPalindrome(sub_str)) {
                    List<List<String>> inner_lls = new ArrayList<>();
                    for (List<String> list : result.get(j)) {
                        List<String> new_list = new ArrayList<>(list);
                        new_list.add(sub_str);
                        inner_lls.add(new_list);
                    }
                    outer_lls.addAll(inner_lls);
                }
            }
            result.add(outer_lls);
        }
        return result.get(result.size() - 1);
    }
}

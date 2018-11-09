import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (32.78%)
 * Total Accepted:    255.8K
 * Total Submissions: 780.3K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        int maxWordLen = 0;
        for (String word : dict) {
            maxWordLen = Math.max(maxWordLen, word.length());
        }
        boolean[] canBeBreak = new boolean[len + 1];
        canBeBreak[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxWordLen); j--) {
                if (dict.contains(s.substring(j, i)) && canBeBreak[j]) {
                    canBeBreak[i] = true;
                    break;
                }
            }
        }
        return canBeBreak[len];
    }
}

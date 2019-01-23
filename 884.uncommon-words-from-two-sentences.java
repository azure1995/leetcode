import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * [920] Uncommon Words from Two Sentences
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 *
 * algorithms
 * Easy (60.04%)
 * Total Accepted:    11.9K
 * Total Submissions: 19.8K
 * Testcase Example:  '"this apple is sweet"\n"this apple is sour"'
 *
 * We are given two sentences A and B.  (A sentence is a string of space
 * separated words.  Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words. 
 * 
 * You may return the list in any order.
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
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 * 
 * 
 * 
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String AB = A + " " + B;
        List<String> list = Arrays.asList(AB.split("\\s+"));
        Set<String> set = new HashSet<>();
        Set<String> diff = new HashSet<>();
        for (String s : list) {
            if (set.add(s)) {
                diff.add(s);
            } else {
                diff.remove(s);
            }
        }
        return diff.toArray(new String[0]);
    }
}

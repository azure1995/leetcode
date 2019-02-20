<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.73%)
 * Total Accepted:    227.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * Example:  
 * 
 * 
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 */
public class Solution {
    public String reverseWords(String s) {
        String formated_s = s.trim().replaceAll("\\s+", " ");
        List<String> splited_s = Arrays.asList(formated_s.split(" "));
        Collections.reverse(splited_s);
        return String.join(" ", splited_s);
    }
}
=======
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.73%)
 * Total Accepted:    227.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * Example:  
 * 
 * 
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 */
public class Solution {
    public String reverseWords(String s) {
        String formated_s = s.trim().replaceAll("\\s+", " ");
        List<String> splited_s = Arrays.asList(formated_s.split(" "));
        Collections.reverse(splited_s);
        return String.join(" ", splited_s);
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284

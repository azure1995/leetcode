/*
 * [953] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (59.94%)
 * Total Accepted:    4.8K
 * Total Submissions: 8.2K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
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
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int left = 0, right = S.length()-1;
        while (left < right) {
            while (left < right && !isCharacter(charArray[left])) {
                left++;
            }
            while (right > left && !isCharacter(charArray[right])) {
                right--;
            }
            char t = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = t;
            left++;
            right--;
        }
        return new String(charArray);
    }
}

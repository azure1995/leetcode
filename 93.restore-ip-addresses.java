<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

/*
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (29.55%)
 * Total Accepted:    116.7K
 * Total Submissions: 395.1K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> get(String s, int part) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0 || part * 3 < s.length()) {
            return result;
        }
        if (part == 1) {
            if (s.equals("0") || (s.charAt(0) != '0' && Integer.parseInt(s) <= 255)) {
                result.add(s);
            }
            return result;
        }
        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            if ((i > 1 && s.charAt(0) == '0') || (i == 3 && Integer.parseInt(s.substring(0, 3)) > 255)) {
                break;
            }
            for (String ele : get(s.substring(i), part - 1)) {
                result.add(s.substring(0, i) + "." + ele);
            }
        }
        return result;
    }

    public List<String> restoreIpAddresses(String s) {
        return get(s, 4);
    }
    // public static void main(String[] args) {
    // System.out.println(Integer.parseInt("001"));
    // }
}
=======
import java.util.ArrayList;
import java.util.List;

/*
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (29.55%)
 * Total Accepted:    116.7K
 * Total Submissions: 395.1K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> get(String s, int part) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0 || part * 3 < s.length()) {
            return result;
        }
        if (part == 1) {
            if (s.equals("0") || (s.charAt(0) != '0' && Integer.parseInt(s) <= 255)) {
                result.add(s);
            }
            return result;
        }
        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            if ((i > 1 && s.charAt(0) == '0') || (i == 3 && Integer.parseInt(s.substring(0, 3)) > 255)) {
                break;
            }
            for (String ele : get(s.substring(i), part - 1)) {
                result.add(s.substring(0, i) + "." + ele);
            }
        }
        return result;
    }

    public List<String> restoreIpAddresses(String s) {
        return get(s, 4);
    }
    // public static void main(String[] args) {
    // System.out.println(Integer.parseInt("001"));
    // }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284

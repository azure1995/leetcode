import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (24.39%)
 * Total Accepted:    108K
 * Total Submissions: 442.9K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * 
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * 
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 */
class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String aFirst = a.toString() + b.toString();
                String bFirst = b.toString() + a.toString();
                return bFirst.compareTo(aFirst);
            }
        });
        StringBuilder result = new StringBuilder();
        for (Integer num : list) {
            result.append(num.toString());
        }
        int zero_end = 0;
        while (result.charAt(zero_end) == '0' && zero_end < result.length() - 1) {
            zero_end++;
        }
        result.delete(0, zero_end);
        return result.toString();
    }
}

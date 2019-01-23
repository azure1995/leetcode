import java.util.Arrays;
import java.util.stream.Stream;

/*
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (36.72%)
 * Total Accepted:    151.6K
 * Total Submissions: 412.9K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }
        long[] result = new long[n + 2];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                result[j] = Math.min(result[j - 1], result[j]) + triangle.get(i - 1).get(j - 1);
            }
        }
        long min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, result[i]);
        }
        return (int) min;
    }
}

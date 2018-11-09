import java.util.ArrayList;
import java.util.List;

/*
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (43.71%)
 * Total Accepted:    164.5K
 * Total Submissions: 376.3K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ret = combine(n - 1, k);
        List<List<Integer>> with_n = combine(n - 1, k - 1);
        if (with_n.size() == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(n);
            with_n.add(l);
        } else {
            for (List<Integer> list : with_n) {
                list.add(n);
            }
        }
        ret.addAll(with_n);
        return ret;
    }
}

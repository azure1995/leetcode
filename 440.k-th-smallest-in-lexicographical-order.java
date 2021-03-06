/*
 * @lc app=leetcode id=440 lang=java
 *
 * [440] K-th Smallest in Lexicographical Order
 *
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
 *
 * algorithms
 * Hard (25.99%)
 * Total Accepted:    7.4K
 * Total Submissions: 28.4K
 * Testcase Example:  '13\n2'
 *
 * Given integers n and k, find the lexicographically k-th smallest integer in
 * the range from 1 to n.
 * 
 * Note: 1 ≤ k ≤ n ≤ 109.
 * 
 * Example:
 * 
 * Input:
 * n: 13   k: 2
 * 
 * Output:
 * 10
 * 
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so
 * the second smallest number is 10.
 * 
 * 
 * 
 */
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = helper(n, cur, cur + 1);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    private int helper(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}

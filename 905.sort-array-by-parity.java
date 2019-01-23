import java.util.Arrays;

/*
 * [941] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (71.67%)
 * Total Accepted:    19.7K
 * Total Submissions: 27.5K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] A_copy = A.clone();
        int lastEven = 0;
        for (int i = 0; i < A_copy.length; i++) {
            if (A_copy[i] % 2 == 0) {
                int t = A_copy[i];
                A_copy[i] = A_copy[lastEven]; 
                A_copy[lastEven] = t;
                lastEven++;
            }
        }
        return A_copy;
    }
}

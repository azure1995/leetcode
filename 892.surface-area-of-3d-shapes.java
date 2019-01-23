/*
 * [928] Surface Area of 3D Shapes
 *
 * https://leetcode.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (54.56%)
 * Total Accepted:    5K
 * Total Submissions: 9.2K
 * Testcase Example:  '[[2]]'
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of
 * grid cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
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
 * Input: [[2]]
 * Output: 10
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,2],[3,4]]
 * Output: 34
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[1,0],[0,2]]
 * Output: 16
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    area += 2;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            area += grid[i][0] + grid[i][N-1] + grid[0][i] + grid[N-1][i];
            for (int j = 0; j < N - 1; j++) {
                area += Math.abs(grid[i][j+1] - grid[i][j]) + Math.abs(grid[j+1][i] - grid[j][i]);
            }
        }
        return area;
    }
}

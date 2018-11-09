/*
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (38.25%)
 * Total Accepted:    234K
 * Total Submissions: 611.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
class Solution {
    int n;
    int m;
    char[][] globalGrid;
    boolean[][] visited;
    int[][] directs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public void dfs(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int new_row = row + directs[i][0];
            int new_col = col + directs[i][1];
            if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && globalGrid[new_row][new_col] == '1'
                    && !visited[new_row][new_col]) {
                dfs(new_row, new_col);
            }
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        globalGrid = grid;
        visited = new boolean[n][m];
        int islandNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }
}

class Solution {
    final int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ret = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int len = 0, sy = -1, sx = -1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    len++;     
                }
                if (grid[r][c] == 1) {
                    sy = r;
                    sx = c;
                }
            }
        }
        dfs(grid, 0, len, sy, sx);
        return ret;
    }
    
    private void dfs(int[][] grid, int count, int len, int py, int px) {
        for (int d = 0; d < 4; d++) {
            int ny = directs[d][0] + py, nx = directs[d][1] + px;
            if (ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[0].length) {
                if (count == len && grid[ny][nx] == 2) {
                    ret++;
                    return;
                } else if (count < len && grid[ny][nx] == 0) {
                    grid[ny][nx] = -1;
                    dfs(grid, count + 1, len, ny, nx);
                    grid[ny][nx] = 0;
                }
            } 
        }
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int l = grid[0][0], h = N * N - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            int[][] visited = new int[N][N];
            visited[0][0] = 1;
            if (dfs(0, 0, grid, visited, N, mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h + 1;
    }

    private boolean dfs(int i, int j, int[][] grid, int[][] visited, int N, int n) {
        if (i == N - 1 && j == N - 1) {
            return true;
        }
        int[][] di = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int[] d : di) {
            int ni = i + d[0], nj = j + d[1];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && visited[ni][nj] == 0 & grid[ni][nj] <= n) {
                visited[ni][nj] = 1;
                if (dfs(ni, nj, grid, visited, N, n)) {
                    return true;
                }
            }
        }
        return false;
    }
}

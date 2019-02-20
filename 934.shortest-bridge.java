class Solution {
    final int[][] directs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public void dfs(int r, int c, int N, int[][] A, boolean[][] visited, Queue<int[]> queue) {
        for (int d = 0; d < directs.length; d++) {
            int next_r = r + directs[d][0], next_c = c + directs[d][1];
            if (next_r >= 0 && next_r < N && next_c >= 0 && next_c < N && !visited[next_r][next_c]
                    && A[next_r][next_c] == 1) {
                visited[next_r][next_c] = true;
                queue.offer(new int[] { next_r, next_c, 0 });
                dfs(next_r, next_c, N, A, visited, queue);
            }
        }
    }

    public int shortestBridge(int[][] A) {
        int N = A.length;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0, found = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (A[r][c] == 1) {
                    visited[r][c] = true;
                    queue.offer(new int[] { r, c, 0 });
                    dfs(r, c, N, A, visited, queue);
                    found = 1;
                    break;
                }
            }
            if (found == 1) break;
        }
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int r = head[0], c = head[1], step = head[2];
            for (int d = 0; d < directs.length; d++) {
                int next_r = r + directs[d][0], next_c = c + directs[d][1];
                if (next_r >= 0 && next_r < N && next_c >= 0 && next_c < N && !visited[next_r][next_c]) {
                    if (A[next_r][next_c] == 1) {
                        return step;
                    }
                    visited[next_r][next_c] = true;
                    queue.offer(new int[] { next_r, next_c, step + 1 });
                }
            }
        }
        throw null;
    }
}

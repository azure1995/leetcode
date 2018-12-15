class Solution {
    public int[] get(int N, int p) {
        int[] ret = new int[2];
        ret[0] = N - 1 - (p - 1) / N;
        ret[1] = N % 2 != ret[0] % 2 ? (p - 1) % N : N - 1 - (p - 1) % N;
        return ret;
    }

    public int snakesAndLadders(int[][] board) {
        int[] directs = { -1, 1 };
        int N = board[0].length;
        boolean[] visited = new boolean[N * N + 1];
        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(new int[] { 1, 0 });
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int p = head[0], step = head[1];
            for (int i = p + 1; i <= Math.min(p + 6, N * N); i++) {
                int[] dest = get(N, i);
                int np = board[dest[0]][dest[1]] > 0 ? board[dest[0]][dest[1]] : i;
                if (np == N * N) {
                    return step + 1;
                }
                if (!visited[np]) {
                    visited[np] = true;
                    queue.offer(new int[] { np, step + 1 });
                }
            }
        }
        return -1;
    }
}

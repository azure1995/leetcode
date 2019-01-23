class Solution {
    public int minCut(String s) {
        char[] chArr = s.toCharArray();
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }
        for (int d = 1; d < N; d++) {
            for (int l = 0; l < N - d; l++) {
                dp[l][d + l] = chArr[l] == chArr[l + d] && (d == 1 || dp[l + 1][l + d - 1]);
            }
        }
        boolean[] visited = new boolean[N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            if (head[0] == N) {
                return head[1] - 1;
            }
            for (int i = head[0]; i < N; i++) {
                if (!visited[i] && dp[head[0]][i]) {
                    visited[i] = true;
                    queue.offer(new int[] { i + 1, head[1] + 1 });
                }
            }
        }
        throw null;
    }
}
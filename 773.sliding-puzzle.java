class Solution {
    public int slidingPuzzle(int[][] board) {
        if (reached(board)) {
            return 0;
        }
        Set<String> memo = new HashSet<>();
        Queue<int[][]> cur = new LinkedList<>();
        cur.offer(board);
        Queue<int[]> curz = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    curz.offer(new int[] { i, j });
                    break;
                }
            }
            if (!curz.isEmpty()) {
                break;
            }
        }
        int ans = 0;
        int[][] di = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!cur.isEmpty()) {
            ans++;
            Queue<int[][]> next = new LinkedList<>();
            Queue<int[]> nextz = new LinkedList<>();
            while (!cur.isEmpty()) {
                int[][] cs = cur.poll();
                int[] zp = curz.poll();
                int zi = zp[0], zj = zp[1];
                for (int[] d : di) {
                    int nzi = zi + d[0], nzj = zj + d[1];
                    if (0 <= nzi && nzi < 2 && 0 <= nzj && nzj < 3) {
                        int[][] ns = copy(cs);
                        ns[zi][zj] = ns[nzi][nzj];
                        ns[nzi][nzj] = 0;
                        if (reached(ns)) {
                            return ans;
                        }
                        String s = concat(ns);
                        if (!memo.contains(s)) {
                            memo.add(s);
                            next.offer(ns);
                            nextz.offer(new int[] { nzi, nzj });
                        }
                    }
                }
            }
            cur = next;
            curz = nextz;
        }
        return -1;
    }

    private boolean reached(int[][] board) {
        return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 && board[1][0] == 4 && board[1][1] == 5
                && board[1][2] == 0;
    }

    private String concat(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private int[][] copy(int[][] ori) {
        int[][] ans = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = ori[i][j];
            }
        }
        return ans;
    }
}

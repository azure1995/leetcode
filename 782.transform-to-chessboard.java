class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length, mask = (1 << N) - 1;
        int ret = 0;
        int cr = helper(board, N, mask);
        if (cr == -1) {
            return -1;
        }
        ret += cr;
        int[][] re_board = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                re_board[r][c] = board[c][r];
            }
        }
        int cc = helper(re_board, N, mask);
        if (cc == -1) {
            return -1;
        }
        return ret + cc;
    }

    private int get(int[] arr, int N) {
        int num = 0;
        for (int i = 0; i < N; i++) {
            num += arr[i] * (1 << i);
        }
        return num;
    }

    private int helper(int[][] board, int N, int mask) {
        int[] rec = new int[N];
        rec[0] = get(board[0], N);
        int c1 = 1, c2 = 0;
        for (int i = 1; i < N; i++) {
            rec[i] = get(board[i], N);
            if (rec[i] == rec[0]) {
                c1++;
            } else if (rec[i] == (rec[0] ^ mask)) {
                c2++;
            } else {
                return -1;
            }
        }
        if (Math.abs(c1 - c2) <= 1) {
            int l = c1 >= c2 ? rec[0] : (rec[0] ^ mask);
            int diff = 0;
            for (int i = 0; i < N; i += 2) {
                if (rec[i] != l) {
                    diff++;
                }
            }
            return c1 == c2 ? Math.min(diff, N / 2 - diff) : diff;
        }
        return -1;
    }
}

class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] squares = new boolean[9][9];
    Map<Integer, Integer> map = new HashMap<>();

    public void setNext(char[][] board) {
        for (int i = 0, pre = -1; i < 81; i++) {
            if (board[i / 9][i % 9] == '.') {
                map.put(pre, i);
                pre = i;
            }
        }
    }

    public void set(int rc, int num, boolean add) {
        int r = rc / 9, c = rc % 9;
        rows[r][num - 1] = cols[c][num - 1] = squares[(r / 3) * 3 + (c / 3)][num - 1] = add;
    }

    public boolean dfs(int rc, char[][] board) {
        if (!map.containsKey(rc)) {
            return true;
        }
        int next = map.get(rc);
        int r = map.get(rc) / 9, c = map.get(rc) % 9;
        for (int i = 0; i < 9; i++) {
            if (!rows[r][i] && !cols[c][i] && !squares[(r / 3) * 3 + (c / 3)][i]) {
                board[r][c] = (char) ('1' + i);
                set(next, i + 1, true);
                if (dfs(next, board)) {
                    return true;
                }
                set(next, i + 1, false);
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    rows[r][num - 1] = true;
                    cols[c][num - 1] = true;
                    squares[(r / 3) * 3 + (c / 3)][num - 1] = true;
                }
            }
        }
        setNext(board);
        dfs(-1, board);
    }
}

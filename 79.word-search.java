class Solution {
    private boolean dfs(char[][] board, int r, int c, int i, String word) {
        if (board[r][c] != word.charAt(i)) {
            return false;
        } else if (i == word.length() - 1) {
            return true;
        }
        board[r][c] = '#';
        if (r - 1 >= 0 && dfs(board, r - 1, c, i + 1, word)) {
            return true;
        }
        if (r + 1 < board.length && dfs(board, r + 1, c, i + 1, word)) {
            return true;
        }
        if (c - 1 >= 0 && dfs(board, r, c - 1, i + 1, word)) {
            return true;
        }
        if (c + 1 < board[0].length && dfs(board, r, c + 1, i + 1, word)) {
            return true;
        }
        board[r][c] = word.charAt(i);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        } 
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, r, c, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}

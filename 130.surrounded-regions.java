import java.util.Queue;

/*
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (20.94%)
 * Total Accepted:    118.3K
 * Total Submissions: 565K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D char_board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the char_board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the char_board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    int[][] directs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int n, m;
    char[][] char_board;
    boolean[][] visited;

    public void visit(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int new_row = row + directs[i][0];
            int new_col = col + directs[i][1];
            if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && char_board[new_row][new_col] == 'O'
                    && visited[new_row][new_col] == false) {
                visit(new_row, new_col);
            }
        }
    }

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        char_board = board;
        visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (char_board[0][i] == 'O' && visited[0][i] == false) {
                visit(0, i);
            }
            if (char_board[n - 1][i] == 'O' && visited[n - 1][i] == false) {
                visit(n - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (char_board[i][0] == 'O' && visited[i][0] == false) {
                visit(i, 0);
            }
            if (char_board[i][m - 1] == 'O' && visited[i][m - 1] == false) {
                visit(i, m - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

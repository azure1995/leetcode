class Solution {

    public boolean validTicTacToe(String[] board) {
        int Xs = 0, Os = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    Xs++;
                }
                if (board[i].charAt(j) == 'O') {
                    Os++;
                }
            }
        }
        if (Xs < Os || Xs - Os > 1) {
            return false;
        }
        char pre;
        pre = Xs == Os ? 'X' : 'O';
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == pre) {
                return false;
            }
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            if (board[0].charAt(2) == pre) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                if (board[i].charAt(0) == pre) {
                    return false;
                }
            }
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == pre) {
                    return false;
                }
            }
        }
        return true;
    }
}

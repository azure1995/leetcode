class Solution {

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char ch : hand.toCharArray()) {
            handCount[ch - 'A']++;
        }
        return helper(board + "#", handCount);
    }

    private int helper(String s, int[] h) {
        s = removeConsecutive(s);
        if (s.equals("#"))
            return 0;
        int need = 0, ret = -1;
        char[] chArr = s.toCharArray();
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (chArr[j] == chArr[i])
                continue;
            need = 3 - (j - i);
            if (h[chArr[i] - 'A'] >= need) {
                h[chArr[i] - 'A'] -= need;
                int calc = helper(s.substring(0, i) + s.substring(j), h);
                if (calc >= 0) {
                    ret = ret == -1 ? calc + need : Math.min(ret, calc + need);
                }
                h[chArr[i] - 'A'] += need;
            }
            i = j;
        }
        return ret;
    }

    // remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i))
                continue;
            if (j - i >= 3)
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            else
                i = j;
        }
        return board;
    }
}

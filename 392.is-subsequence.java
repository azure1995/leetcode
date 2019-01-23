class Solution {
    public boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        int[][] next = new int[tLen + 1][26];
        Arrays.fill(next[tLen], -1);
        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j] >= 1 ? (next[i + 1][j] + 1) : -1;
            }
            next[i][t.charAt(i) - 'a'] = 1;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            int nc = next[j][s.charAt(i) - 'a'];
            if (nc == -1) {
                return false;
            }
            j += nc;
        }
        return true;
    }
}
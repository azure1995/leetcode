class Solution {
    final int mod = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[][] memo = new int[len][len];
        return helper(S, 0, S.length() - 1, memo) - 1;
    }

    private int helper(String S, int s, int e, int[][] memo) {
        if (memo[s][e] == 0) {
            int unique = 0;
            int[] set = new int[4];
            for (int i = s; i <= e; i++) {
                if (set[S.charAt(i) - 'a'] == 0) {
                    unique++;
                    set[S.charAt(i) - 'a'] = 1;
                    if (unique == 4) {
                        break;
                    }
                }
            }
            memo[s][e] += unique + 1;
            for (int i = 0; i < 4; i++) {
                int l = s, r = e;
                while (l < r && S.charAt(l) - 'a' != i) {
                    l++;
                }
                while (r > l && S.charAt(r) - 'a' != i) {
                    r--;
                }
                if (S.charAt(l) - 'a' == i && S.charAt(r) - 'a' == i && r > l) {
                    memo[s][e] = (memo[s][e] + helper(S, l + 1, r - 1, memo)) % mod;
                }
            }
        }
        return memo[s][e];
    }
}

class Solution {
    public int minStickers(String[] stickers, String target) {
        int len = target.length();
        int N = stickers.length;
        int[] dp = new int[1 << len];
        int[][] mp = new int[N][26];
        for (int i = 0; i < N; i++) {
            for (char ch : stickers[i].toCharArray()) {
                mp[i][ch - 'a']++;
            }
        }
        for (int i = 1; i < 1 << len; i++)
            dp[i] = -1;
        for (int i = 0; i < 1 << len; i++) {
            if (dp[i] == -1)
                continue;
            for (int j = 0; j < N; j++) {
                int[] tmp = mp[j].clone();
                int cur = i;
                for (int k = 0; k < len; k++) {
                    if (((i >> k) & 1) == 1) {
                        continue;
                    }
                    if (tmp[target.charAt(len - 1 - k) - 'a'] > 0) {
                        tmp[target.charAt(len - 1 - k) - 'a']--;
                        cur |= (1 << k);
                    }
                }
                dp[cur] = Math.min(dp[cur] == -1 ? Integer.MAX_VALUE : dp[cur], dp[i] + 1);
            }
        }
        return dp[(1 << len) - 1];
    }
}

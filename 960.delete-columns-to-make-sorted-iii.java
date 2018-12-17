class Solution {
    private int compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 0;
            }
        }
        return -1;
    }

    public int minDeletionSize(String[] A) {
        int[] dp = new int[A[0].length()];
        String[] rev = new String[A[0].length()];
        for (int i = 0; i < A[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length; j++) {
                sb.append(A[j].charAt(i));
            }
            rev[i] = sb.toString();
        }
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < rev.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (compare(rev[j], rev[i]) == -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return A[0].length() - max;
    }
}

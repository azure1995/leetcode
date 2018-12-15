class Solution {
    public int minFlipsMonoIncr(String S) {
        int counter = 0;
        int dp = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                counter++;
            } else {
                dp = Math.min(dp + 1, counter);
            }
        }
        return dp;
    }
}
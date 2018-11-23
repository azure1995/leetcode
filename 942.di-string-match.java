class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] ret = new int[N + 1];
        ret[0] = 0;
        int lastI = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                lastI = i + 1;
                ret[i + 1] = i + 1;
            } else {
                for (int j = i + 1; j >= lastI + 1; j--) {
                    ret[j] = ret[j - 1];
                }
                ret[lastI] = i + 1;
            }
        }
        return ret;
    }
}

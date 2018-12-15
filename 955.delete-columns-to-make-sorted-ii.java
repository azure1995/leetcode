class Solution {
    public int minDeletionSize(String[] A) {
        int N = A[0].length();
        int ret = 0;
        boolean[] pre = new boolean[A.length];
        for (int i = 0; i < N; i++) {
            boolean[] tmp = new boolean[A.length];
            for (int j = 1; j <= A.length; j++) {
                if (j == A.length) {
                    pre = tmp;
                    break;
                } else if (!pre[j] && A[j - 1].charAt(i) > A[j].charAt(i)) {
                    ret++;
                    break;
                }
                tmp[j] = pre[j] || A[j - 1].charAt(i) != A[j].charAt(i);
            }
        }
        return ret;
    }
}
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int ret = 1;
        int dp1 = 1, dp2 = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dp2 = dp1 + 1;
                dp1 = 1;
            } else if (A[i] < A[i - 1]) {
                dp1 = dp2 + 1;
                dp2 = 1;
            } else {
                dp1 = dp2 = 1;
            }
            ret = Math.max(ret, Math.max(dp1, dp2));
        }
        return ret;
    }
}
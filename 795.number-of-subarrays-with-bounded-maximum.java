class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ret = 0;
        int start = 0;
        for (int end = 0; end <= A.length; end++) {
            if (end == A.length || A[end] > R) {
                ret += (end - start - 1) * (end - start) / 2;
                start = end + 1;
            } else if (A[end] < L) {
                int tmp = end;
                while (end + 1 < A.length && A[end + 1] < L) {
                    end++;
                }
                ret -= (end - tmp) * (end - tmp + 1) / 2;
            } else {
                ret++;
            }
        }
        return ret;
    }
}
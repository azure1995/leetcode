class Solution {
    public int longestMountain(int[] A) {
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            if (i + 1 < A.length && A[i] < A[i + 1]) {
                int len = 1;
                do {
                    i++;
                    len++;
                } while (i + 1 < A.length && A[i] < A[i + 1]);
                if (i == A.length - 1 || A[i] == A[i + 1]) {
                    continue;
                }
                do {
                    i++;
                    len++;
                } while (i + 1 < A.length && A[i] > A[i + 1]);
                ret = Math.max(ret, len);
                if (i + 1 < A.length && A[i] < A[i + 1]) {
                    i--;
                }
            }
        }
        return ret;
    }
}

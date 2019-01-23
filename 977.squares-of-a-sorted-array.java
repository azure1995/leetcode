class Solution {
    public int[] sortedSquares(int[] A) {
        int m = Arrays.binarySearch(A, 0);
        m = m < 0 ? -m - 1 : m;
        int[] ret = new int[A.length];
        for (int i = 0, il = m - 1, ir = m; i < A.length; i++) {
            if (ir == A.length || il >= 0 && A[il] * A[il] <= A[ir] * A[ir]) {
                ret[i] = A[il] * A[il];
                il--;
            } else {
                ret[i] = A[ir] * A[ir];
                ir++;
            }
        }
        return ret;
    }
}
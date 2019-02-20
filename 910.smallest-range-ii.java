class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= A.length; i++) {
            int min = Math.min(A[0] + K, i == A.length ? Integer.MAX_VALUE : A[i] - K);
            int max = Math.max(A[i - 1] + K, A[A.length - 1] - K);
            ret = Math.min(ret, max - min);
        }
        return ret;
    }
}

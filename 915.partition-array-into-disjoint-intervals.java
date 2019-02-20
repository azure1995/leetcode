class Solution {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] mins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            mins[i] = i == N - 1 ? A[N - 1] : Math.min(A[i], mins[i + 1]);
        }
        int max = A[0];
        for (int i = 1; i < N; i++) {
            if (max <= mins[i]) {
                return i;
            }
            max = Math.max(max, A[i]);
        }
        throw null;
    }
}
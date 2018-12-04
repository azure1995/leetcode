class Solution {
    public boolean isIdealPermutation(int[] A) {
        int N = A.length;
        if (N <= 2) {
            return true;
        }
        int min = A[N - 1];
        for (int i = N - 3; i >= 0; i--) {
            if (A[i] > min) {
                return false;
            }
            min = Math.min(min, A[i + 1]);
        }
        return true;
    }
}
class Solution {
    public int maxRotateFunction(int[] A) {
        long sum = Arrays.stream(A).sum();
        int n = A.length;
        long diff = 0;
        long max = 0;
        for (int i = 1; i < n; i++) {
            diff += sum - n * A[n - i];
            max = Math.max(max, diff);
        }
        int initial = 0;
        for (int i = 0; i < n; i++) {
            initial += i * A[i];
        }
        return initial + (int) max;
    }
}
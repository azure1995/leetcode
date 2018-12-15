class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0, acc = 0; i < A.length; i++) {
            acc += A[i];
            max = Math.max(max, acc);
            acc = Math.max(acc, 0);
        }
        int sum = Arrays.stream(A).sum();
        int min = Integer.MAX_VALUE;
        for (int i = 0, acc = 0; i < A.length; i++) {
            acc += A[i];
            min = Math.min(min, acc);
            acc = Math.min(acc, 0);
        }
        if (sum == min) {
            return max;
        }
        return Math.max(max, sum - min);
    }
}
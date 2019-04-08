class Solution {
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);
        int sum = Arrays.stream(A).sum(), N = A.length;
        int gcd = gcd(sum, N);
        sum /= gcd;
        N /= gcd;
        for (int i = 1; i < gcd; i++) {
            int n = i * N;
            int subSum = i * sum;
            if (helper(0, 0, 0, n, subSum, A)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(int st, int count, int sum, int n, int target, int[] A) {
        if (count == n && sum == target) {
            return true;
        }
        for (int i = st; i < A.length; i++) {
            if (helper(i + 1, count + 1, sum + A[i], n, target, A)) {
                return true;
            }
            while (i + 1 < A.length && A[i + 1] == A[i]) {
                i++;
            }
        }
        return false;
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int l = 1, h = A[A.length - 1] * A[A.length - 2];
        while (l <= h) {
            int mid = (l + h) / 2;
            int[] c = count(mid, A);
            if (c[0] > K) {
                h = mid - 1;
            } else if (c[0] == K) {
                return new int[] { c[1], c[2] };
            } else {
                l = mid + 1;
            }
        }
        throw null;
    }

    private int[] count(int n1, int[] A) {
        double top = (n1 + 0.0) / (A[A.length - 1] * A[A.length - 2] + 0.0);
        int[] ans = new int[3];
        ans[2] = 1;
        for (int i = 1; i < A.length; i++) {
            int t = Arrays.binarySearch(A, 0, i, (int) (A[i] * top));
            t = t < 0 ? -t - 2 : t;
            ans[0] += t + 1;
            if (t >= 0 && (0.0 + ans[1]) / (0.0 + ans[2]) < (0.0 + A[t]) / (0.0 + A[i])) {
                ans[1] = A[t];
                ans[2] = A[i];
            }
        }
        return ans;
    }
}

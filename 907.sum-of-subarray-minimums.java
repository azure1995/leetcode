class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> s = new Stack<>();
        int n = A.length, res = 0, mod = (int) 1e9 + 7, j, k;
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? 0 : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res = (res + A[j] * (i - j) * (j - k)) % mod;
            }
            s.push(i);
        }
        return res;
    }
}
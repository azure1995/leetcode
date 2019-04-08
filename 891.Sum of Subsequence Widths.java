import java.util.Arrays;

class Solution {
    public int sumSubseqWidths(int[] A) {
        int mod = (int) 1e9 + 7;
        int N = A.length, ans = 0;
        Arrays.sort(A);
        int[] coes = new int[N];
        for (int i = 0; i < N; i++) {
            coes[i] = i == 0 ? 1 : (coes[i - 1] * 2) % mod;
        }
        for (int i = 0; i < N; i++) {
            ans = (int) ((ans + ((1l * A[i] * (coes[i] - coes[N - 1 - i])) % mod)) % mod);
        }
        return (ans + mod) % mod;
    }
}
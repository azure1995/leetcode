class Solution {
    private int getGCD(int a, int b) {
        return a == 0 ? b : getGCD(b % a, a);
    }

    public int nthMagicalNumber(int N, int A, int B) {
        int mod = (int) 1e9 + 7;
        int gcd = getGCD(A, B);
        int gcm = A * B / gcd;
        int count = gcm / A + gcm / B - 1;
        int cn = N / count;
        int n = N % count;
        int base = (int) ((1l * gcm * cn) % mod);
        if (n == 0) {
            return base;
        }
        int ai = 1, bi = 1;
        int ans = 0;
        while (n > 0) {
            if (ai * A <= bi * B) {
                ans = ai * A;
                ai++;
            } else {
                ans = bi * B;
                bi++;
            }
            n--;
        }
        return (base + ans) % mod;
    }
}

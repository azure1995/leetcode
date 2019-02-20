class Solution {
    public int primePalindrome(int N) {
        if (N > 7 && N <= 11) {
            return 11;
        }
        for (int L = (String.valueOf(N).length() + 1) / 2; L <= 5; ++L) {
            for (int root = (int) Math.pow(10, L - 1); root < (int) Math.pow(10, L); ++root) {
                StringBuilder sb = new StringBuilder(Integer.toString(root));
                for (int k = L - 2; k >= 0; --k)
                    sb.append(sb.charAt(k));
                int x = Integer.valueOf(sb.toString());
                if (x >= N && isPrime(x))
                    return x;
            }
        }
        throw null;
    }

    public boolean isPrime(int N) {
        if (N < 2)
            return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0)
                return false;
        return true;
    }
}
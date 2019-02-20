class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] count = { 0, 1, (int) 2e1, (int) 3e2, (int) 4e3, (int) 5e4, (int) 6e5, (int) 7e6, (int) 8e7, (int) 9e8 };
        char[] digits = String.valueOf(n).toCharArray();
        int N = digits.length;
        int[] preOnes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preOnes[i] = preOnes[i - 1] + (digits[i - 1] == '1' ? 1 : 0);
        }
        int t = 1, ret = preOnes[N];
        for (int i = N - 1; i >= 0; i--, t *= 10) {
            ret += t * ((digits[i] > '1' ? 1 : 0) + (digits[i] - '0') * preOnes[i]);
            ret += (digits[i] - '0') * count[N - 1 - i];
        }
        return ret;
    }
}


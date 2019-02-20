class Solution {
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private int[] toFraction(String s) {
        int[] ret = new int[3];
        StringBuilder[] sb = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            sb[i] = new StringBuilder();
        }
        int state = 0;
        for (char d : s.toCharArray()) {
            if (d == '.' || d == '(' || d == ')') {
                state++;
                continue;
            }
            sb[state].append(d);
        }
        ret[0] = Integer.valueOf(sb[0].toString());
        int len = sb[1].length();
        int[] non_r = new int[2];
        non_r[0] = (int) Math.pow(10, len);
        while (sb[1].length() > 1 && sb[1].charAt(0) == '0') {
            sb[1].deleteCharAt(0);
        }
        non_r[1] = sb[1].length() == 0 ? 0 : Integer.valueOf(sb[1].toString());
        int[] r = new int[2];
        r[0] = (int) Math.pow(10, len) * ((int) Math.pow(10, sb[2].length()) - 1);
        while (sb[2].length() > 1 && sb[2].charAt(0) == '0') {
            sb[2].deleteCharAt(0);
        }
        r[1] = sb[2].length() == 0 ? 0 : Integer.valueOf(sb[2].toString());
        int dividend = r[0] > 0 ? r[0] : non_r[0], divisor = r[0] > 0 ? r[1] + non_r[1] * (r[0] / non_r[0]) : non_r[1];
        if (divisor >= dividend) {
            ret[0] += divisor / dividend;
            divisor %= dividend;
        }
        if (divisor == 0) {
            ret[1] = ret[2] = 0;
        } else {
            int gcd = getGCD(dividend, divisor);
            ret[1] = dividend / gcd;
            ret[2] = divisor / gcd;
        }
        return ret;
    }

    public boolean isRationalEqual(String S, String T) {
        int[] sFraction = toFraction(S), tFraction = toFraction(T);
        return sFraction[0] == tFraction[0] && sFraction[1] == tFraction[1] && sFraction[2] == tFraction[2];
    }
}

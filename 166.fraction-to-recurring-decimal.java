import java.math.BigInteger;
import java.math.BigDecimal;

class Solution {
    public int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "NaN";
        }
        if (numerator == 0) {
            return "0";
        }
        int gcd = Math.abs(getGCD(numerator, denominator));
        long ln = (long) numerator / gcd;
        long ld = (long) denominator / gcd;
        String sign = ((double) ln / (double) ld) > 0 ? "" : "-";
        ln = Math.abs(ln);
        ld = Math.abs(ld);
        long temp = ld;
        int power2 = 0;
        int power5 = 0;
        while (temp % 2 == 0) {
            temp /= 2;
            power2++;
        }
        while (temp % 5 == 0) {
            temp /= 5;
            power5++;
        }
        if (temp == 1) {
            if (ln % ld == 0) {
                return sign + String.valueOf(ln / ld);
            } else {
                return sign + BigDecimal.valueOf(ln).divide(BigDecimal.valueOf(ld)).toPlainString();
            }
        } else {
            int p = 0;
            BigInteger tb = BigInteger.valueOf(Math.abs(temp));
            BigInteger db = BigInteger.valueOf(Math.abs(ld));
            BigInteger nb = BigInteger.valueOf(Math.abs(ln));
            BigInteger numerator_afterDivide = nb.multiply(BigInteger.valueOf(10).pow(Math.max(power2, power5)))
                    .divide(db.divide(tb));
            System.out.println(numerator_afterDivide.toString());
            db = tb;
            BigInteger intPart = numerator_afterDivide.divide(db);
            BigInteger numerator_afterDivide_afterMod = numerator_afterDivide.mod(db);
            BigInteger bi = BigInteger.valueOf(1);
            do {
                bi = bi.multiply(BigInteger.valueOf(10));
                p++;
            } while (bi.mod(db).compareTo(BigInteger.valueOf(1)) != 0);
            String repeat = bi.divide(db).multiply(numerator_afterDivide_afterMod).toString();
            int diff = p - repeat.length();
            for (int i = 0; i < diff; i++) {
                repeat = "0" + repeat;
            }
            String int_str;
            if (intPart.compareTo(BigInteger.valueOf(0)) == 0) {
                int len = Math.max(power2, power5);
                int_str = "0.";
                for (int i = 0; i < len; i++) {
                    int_str += "0";
                }
            } else {
                int_str = new BigDecimal(intPart).divide(BigDecimal.valueOf(10).pow(Math.max(power2, power5)))
                        .toString();
                if (Math.max(power2, power5) == 0) {
                    int_str += ".";
                }
            }
            return sign + int_str + "(" + repeat + ")";
        }
    }
}

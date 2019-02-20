class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        int d = (int) (Math.log(num) / Math.log(2));
        for (int m = d; m >= 2; m--) {
            long k = (long) Math.pow(num, 1.0 / m);
            long sum = 0, p = 1;
            for (int i = 0; i <= m; i++) {
                sum += p;
                p *= k;
            }
            if (sum == num) {
                return "" + k;
            }
        }
        return "" + (num - 1);
    }
}
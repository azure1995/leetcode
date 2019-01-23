class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_2 = 2, next_multiple_3 = 3, next_multiple_5 = 5;
        int next_ugly = 1;
        for (int i = 1; i < n; i++) {
            next_ugly = Math.min(Math.min(next_multiple_2, next_multiple_3), next_multiple_5);
            ugly[i] = next_ugly;
            if (next_ugly == next_multiple_2) {
                i2++;
                next_multiple_2 = ugly[i2] * 2;
            }
            if (next_ugly == ugly[i3] * 3) {
                i3++;
                next_multiple_3 = ugly[i3] * 3;
            }
            if (next_ugly == ugly[i5] * 5) {
                i5++;
                next_multiple_5 = ugly[i5] * 5;
            }
        }
        return next_ugly;
    }
}
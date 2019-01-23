class Solution {
    public int lastRemaining(int n) {
        int first = 1, num = n;
        int powTwo = 1;
        int sign = 1;
        while (num > 1) {
            num /= 2;
            first += sign * powTwo * (2 * num - 1);
            sign *= -1;
            powTwo *= 2;
        }
        return first;
    }
}
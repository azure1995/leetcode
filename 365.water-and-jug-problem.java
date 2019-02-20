<<<<<<< HEAD
class Solution {
    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        } else if (z > x + y) {
            return false;
        }
        if (x == y) {
            return z == x || z == 2 * x;
        } else {
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
            if (x == 0) {
                return z == y;
            }
        }
        int gcd = getGCD(x, y % x);
        return z % gcd == 0;
    }
=======
class Solution {
    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        } else if (z > x + y) {
            return false;
        }
        if (x == y) {
            return z == x || z == 2 * x;
        } else {
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
            if (x == 0) {
                return z == y;
            }
        }
        int gcd = getGCD(x, y % x);
        return z % gcd == 0;
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}
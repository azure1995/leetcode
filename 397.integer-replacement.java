class Solution {
    public int integerReplacement(int n) {
        int opNum = 0;
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 4 == 1) {
                n--;
            } else {
                if (n == 3) {
                    return opNum + 2;
                }
                n++;
            }
            opNum++;
        }
        return opNum;
    }
}
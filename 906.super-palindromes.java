class Solution {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L), r = Long.valueOf(R);
        int ans = 0;
        for (int i = 0; i <= 1; i++) {
            for (int k = 1;; k++) {
                long con = concat(k, i);
                long square = con * con;
                if (square < l) {
                    continue;
                }
                if (square > r) {
                    break;
                }
                if (isPalindrome(square)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private long concat(int num, int mark) {
        if (mark == 0) {
            return Long.valueOf(num + new StringBuilder(num + "").reverse().toString());
        }
        StringBuilder sb = new StringBuilder(num < 10 ? "" : (num / 10) + "");
        return Long.valueOf(num + sb.reverse().toString());
    }

    private boolean isPalindrome(long num) {
        return num == Long.valueOf(new StringBuilder(num + "").reverse().toString());
    }
}

class Solution {
    public int strongPasswordChecker(String s) {
        int len = s.length();
        int toAdd_ll = 1, toAdd_hl = 1, toAdd_d = 1;
        int[] re = new int[len];
        for (int i = 0; i < len;) {
            if (Character.isLowerCase(s.charAt(i))) toAdd_ll = 0;
            if (Character.isUpperCase(s.charAt(i))) toAdd_hl = 0;
            if (Character.isDigit(s.charAt(i))) toAdd_d = 0;
            int j = i;
            while (i < len && s.charAt(j) == s.charAt(i)) {
                i++;
            }
            re[j] = i - j;
        }
        int ret = 0, missing = toAdd_ll + toAdd_hl + toAdd_d;
        if (len < 6) {
            ret += missing + Math.max(0, 6 - len - missing);
        } else {
            int over = Math.max(0, len - 20), slot = 0;
            ret += over;
            for (int k = 1; k <= 2; k++) {
                for (int i = 0; i < len && over > 0; i++) {
                    if (re[i] < 3 || re[i] % 3 != k - 1) continue; 
                    re[i] -= Math.min(over, k);
                    over -= k;
                }
            }
            for (int i = 0; i < len; i++) {
                if (re[i] >= 3 && over > 0) {
                    int dec = re[i] - 2;
                    re[i] -= over;
                    over -= dec;
                }
                if (re[i] >= 3) slot += re[i] / 3;
            }
            ret += Math.max(missing, slot);
        }
        return ret;
    }
}

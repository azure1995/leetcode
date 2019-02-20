class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int i = 0, dotCount = 0, digCount = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        while (i < s.length() && s.charAt(i) != 'e' && s.charAt(i) != 'E') {
            if (s.charAt(i) == '.') {
                if (++dotCount > 1) {
                    return false;
                }
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            } else {
                digCount++;
            }
            i++;
        }
        if (digCount == 0) {
            return false;
        }
        i++;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        if (i == s.length()) {
            return false;
        }
        while (i < s.length()) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
            i++;
        }
        return true;
    }
}
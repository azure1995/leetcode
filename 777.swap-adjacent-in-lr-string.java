class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int len = start.length();
        int countL = 0, countR = 0;
        for (int i = 0; i < len; i++) {
            if (start.charAt(i) == end.charAt(i)) {
                continue;
            }
            if (start.charAt(i) == 'L' && end.charAt(i) == 'X') {
                countL++;
            } else if (start.charAt(i) == 'X' && end.charAt(i) == 'L') {
                countL--;
            } else if (start.charAt(i) == 'R' && end.charAt(i) == 'X') {
                countR++;
            } else if (start.charAt(i) == 'X' && end.charAt(i) == 'R') {
                countR--;
            } else {
                return false;
            }
            if (countL*countR != 0 || countL > 0 || countR < 0) {
                return false;
            }
        }
        return countL == 0 && countR == 0;
    }
}

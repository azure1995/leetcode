class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length() - 1; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }
            if (Long.parseLong(num.substring(0, i)) > Long.MAX_VALUE) {
                break;
            }
            for (int j = i + 1; j < num.length(); j++) {
                if (j > i + 1 && num.charAt(i) == '0') {
                    break;
                }
                if (Long.parseLong(num.substring(i, j)) > Long.MAX_VALUE) {
                    break;
                }
                long a = Long.parseLong(num.substring(0, i));
                long b = Long.parseLong(num.substring(i, j));
                int beginIndex, endIndex = j;
                do {
                    beginIndex = endIndex;
                    if (beginIndex == num.length()) {
                        return true;
                    }
                    long temp = a;
                    a = b;
                    b += temp;
                    endIndex = beginIndex + String.valueOf(b).length();
                } while (endIndex <= num.length() && b == Long.parseLong(num.substring(beginIndex, endIndex)));
            }
        }
        return false;
    }
}
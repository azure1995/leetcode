class Solution {

    public int countLeading1(String s) {
        if (s.length() < 8) {
            return 0;
        }
        int i = 0;
        while (i < s.length() && s.charAt(i++) == '1');
        return i - 1;
    }

    public boolean validUtf8(int[] data) {
        int leadingWith10Num = 0;
        for (int i = 0; i < data.length; i++) {
            String bs = Integer.toBinaryString(data[i]);
            int leading1 = countLeading1(bs.length() > 8 ? bs.substring(bs.length() - 8) : bs);
            if (leading1 > 4) {
                return false;
            }
            if ((leadingWith10Num > 0 && leading1 != 1) || (leadingWith10Num == 0 && leading1 == 1)) {
                return false;
            } else if (leadingWith10Num > 0 && leading1 == 1) {
                leadingWith10Num--;
            } else if (leadingWith10Num == 0 && leading1 > 1) {
                leadingWith10Num = leading1 - 1;
            }
        }
        return leadingWith10Num == 0;
    }
};
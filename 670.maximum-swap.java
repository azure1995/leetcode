class Solution {
    public int maximumSwap(int num) {
        int[] rec = new int[10];
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (rec[chars[i] - '0'] == 0) {
                rec[chars[i] - '0'] = i;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                if (rec[j] > i) {
                    char t = chars[rec[j]];
                    chars[rec[j]] = chars[i];
                    chars[i] = t;
                    return Integer.valueOf(String.valueOf(chars));
                }
            }
        }
        return num;
    }
}
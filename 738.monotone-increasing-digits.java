class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int t = i;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
            }
            if (i < chars.length - 1 && chars[i] > chars[i + 1]) {
                chars[t]--;
                for (int j = t + 1; j < chars.length; j++) {
                    chars[j] = '9';
                }
                return Integer.valueOf(String.valueOf(chars));
            }
        }
        return N;
    }
}
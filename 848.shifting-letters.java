class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int N = S.length();
        StringBuilder sb = new StringBuilder();
        int shift = 0;
        for (int i = N - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            sb.append(alphabet[(S.charAt(i) - 'a' + shift) % 26]);
        }
        return sb.reverse().toString();
    }
}

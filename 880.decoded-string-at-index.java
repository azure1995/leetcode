class Solution {
    public String decodeAtIndex(String S, int K) {
        long counter = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                counter++;
                if (counter == K) {
                    return String.valueOf(S.charAt(i));
                }
            } else {
                int tmp = (int) counter;
                counter *= (S.charAt(i) - '0');
                if (counter >= K) {
                    return decodeAtIndex(S.substring(0, i), (K - 1) % tmp + 1);
                }
            }
        }
        throw null;
    }
}
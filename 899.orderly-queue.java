class Solution {
    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            String min = S;
            for (int i = 1; i < S.length(); i++) {
                String ns = S.substring(i) + S.substring(0, i);
                if (min.compareTo(ns) > 0) {
                    min = ns;
                }
            }
            return min;
        }
        char[] chArr = S.toCharArray();
        Arrays.sort(chArr);
        StringBuilder sb = new StringBuilder();
        for (char ch : chArr) sb.append(ch);
        return sb.toString();
    }
}
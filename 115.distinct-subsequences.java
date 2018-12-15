class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() == 0) {
            return 1;
        }
        int[] rec = new int[s.length() + 1];
        Arrays.fill(rec, 1);
        for (int ti = 0; ti < t.length(); ti++) {
            int[] temp = new int[s.length() + 1];
            for (int si = 1; si <= s.length(); si++) {
                temp[si] = temp[si - 1];
                if (s.charAt(si - 1) == t.charAt(ti)) {
                    temp[si] += rec[si - 1];
                }
            }
            if (ti == t.length() - 1) {
                return temp[s.length()];
            }
            rec = temp;
        }
        throw null;
    }
}
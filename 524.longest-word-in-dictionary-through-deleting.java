class Solution {
    Comparator<String> comp = new Comparator<String>() {
        public int compare(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return s1.length() > s2.length() ? -1 : 1;
            } else {
                return s1.compareTo(s2);
            }
        }
    };

    public boolean isSubsequence(String subs, String s) {
        if (subs.length() > s.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < subs.length()) {
            while (j < s.length() && subs.charAt(i) != s.charAt(j++))
                ;
            if (j == s.length() && (i < subs.length() - 1 || subs.charAt(i) != s.charAt(j - 1))) {
                return false;
            }
            if (subs.length() - i > s.length() - j + 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, comp);
        for (String str : d) {
            if (isSubsequence(str, s)) {
                return str;
            }
        }
        return "";
    }
}
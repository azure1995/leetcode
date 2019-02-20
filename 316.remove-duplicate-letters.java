class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        char small = s.charAt(0);
        int i = 0, index = 0;
        for (char ch : s.toCharArray()) {
            if (ch < small) {
                small = ch;
                index = i;
            }
            count[ch - 'a']--;
            if (count[ch - 'a'] == 0) {
                break;
            }
            i++;
        }
        String ns = s.substring(index + 1).replaceAll("" + small, "");
        return small + removeDuplicateLetters(ns);
    }
}

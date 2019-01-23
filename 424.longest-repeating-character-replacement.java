class Solution {
    public int characterReplacement(String s, int k) {
        if (k == s.length()) {
            return s.length();
        }
        int[] charCount = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++charCount[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                charCount[s.charAt(start++) - 'A']--;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
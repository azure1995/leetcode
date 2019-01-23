class Solution {
    public int longestSubstring(String s, int k) {
        if (k <= 1 || s.length() == 0) {
            return s.length();
        }
        Map<Character, Long> counter = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        long lessThanK = counter.entrySet().stream().filter(e -> e.getValue() < k).count();
        if (lessThanK > 0) {
            int max = 0;
            int prev = 0;
            for (int i = 0; i <= s.length(); i++) {
                if (i == s.length() || counter.get(s.charAt(i)) < k) {
                    max = Math.max(max, longestSubstring(s.substring(prev, i), k));
                    prev = i + 1;
                }
            }
            return max;
        }
        return s.length();
    }
}
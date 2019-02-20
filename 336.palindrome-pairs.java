class Solution {
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (String ls : map.keySet()) {
            for (int k = 0; k <= ls.length(); k++) {
                if (isPalindrome(ls.substring(0, k))) {
                    String re = new StringBuilder(ls.substring(k)).reverse().toString();
                    if (re.equals(ls))
                        continue;
                    if (map.containsKey(re)) {
                        ret.add(Arrays.asList(new Integer[] { map.get(re), map.get(ls) }));
                    }
                }
            }
            for (int k = ls.length() - 1; k >= 0; k--) {
                if (isPalindrome(ls.substring(k))) {
                    String re = new StringBuilder(ls.substring(0, k)).reverse().toString();
                    if (re.equals(ls))
                        continue;
                    if (map.containsKey(re)) {
                        ret.add(Arrays.asList(new Integer[] { map.get(ls), map.get(re) }));
                    }
                }
            }
        }
        return ret;
    }
}
class Solution {
    Map<String, Map<String, Boolean>> map = new HashMap<>();

    public boolean isSame(String s1, String s2) {
        Map<Character, Integer> cmap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            cmap.put(s1.charAt(i), cmap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!cmap.containsKey(s2.charAt(i))) {
                return false;
            }
            cmap.put(s2.charAt(i), cmap.get(s2.charAt(i)) - 1);
            if (cmap.get(s2.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(String s1, String s2) {
        if (map.containsKey(s1) && map.get(s1).containsKey(s2)) {
            return map.get(s1).get(s2);
        }
        if (s1.equals(s2)) {
            return true;
        } else if (!isSame(s1, s2)) {
            return false;
        }
        int len = s1.length();
        boolean is = false;
        for (int i = 1; i < len && !is; i++) {
            is = (dfs(s1.substring(0, i), s2.substring(0, i)) && dfs(s1.substring(i), s2.substring(i)))
                    || (dfs(s1.substring(0, i), s2.substring(len - i)) && dfs(s1.substring(i), s2.substring(0, len - i)));
        }
        if (!map.containsKey(s1)) {
            map.put(s1, new HashMap<>());
        }
        map.get(s1).put(s2, is);
        return is;
    }

    public boolean isScramble(String s1, String s2) {
        return s1.length() == s2.length() && dfs(s1, s2);
    }
}

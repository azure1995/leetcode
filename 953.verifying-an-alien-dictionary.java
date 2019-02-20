class Solution {
    public boolean compare(String s1, String s2, Map<Character, Integer> map) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (map.get(s1.charAt(i)) != map.get(s2.charAt(i))) {
                return map.get(s1.charAt(i)) < map.get(s2.charAt(i));
            } 
        }
        return s1.length() <= s2.length();
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }
}
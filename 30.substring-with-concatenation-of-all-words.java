class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return Collections.EMPTY_LIST;
        }
        int wLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < s.length() - words.length * wLen + 1; i++) {
            Map<String, Integer> counter = new HashMap<>();
            for (int j = i; j <= i + words.length * wLen; j += wLen) {
                if (j == i + words.length * wLen) {
                    ret.add(i);
                    break;
                }
                String subs = s.substring(j, j + wLen);
                counter.put(subs, counter.getOrDefault(subs, 0) + 1);
                if (!map.containsKey(subs) || map.get(subs) < counter.get(subs)) {
                    break;
                }
            }
        }
        return ret;
    }
}

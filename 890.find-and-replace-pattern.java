class Solution {
    class chars {
        char c;
        int count;

        chars(char c, int count) {
            this.c = c;
            this.count = 1;
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int len = pattern.length();
        List<chars> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            chars c = new chars(pattern.charAt(i), 1);
            while (i + 1 < pattern.length() && pattern.charAt(i) == pattern.charAt(i + 1)) {
                i++;
                c.count++;
            }
            list.add(c);
        }
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            int j = 0, k = 0;
            while (j < len && k < list.size()) {
                char c = word.charAt(j);
                char mc = list.get(k).c;
                if (map1.getOrDefault(mc, c) != c || map2.getOrDefault(c, mc) != mc) {
                    break;
                }
                int count = 1;
                while (j + 1 < len && word.charAt(j) == word.charAt(j + 1)) {
                    j++;
                    count++;
                }
                if (count != list.get(k).count) {
                    break;
                }
                map1.put(mc, c);
                map2.put(c, mc);
                j++;
                k++;
            }
            if (j == len && k == list.size()) {
                ret.add(word);
            }
        }
        return ret;
    }
}

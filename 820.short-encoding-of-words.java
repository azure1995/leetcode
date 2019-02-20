class Solution {
    Comparator<String> comp = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return s1.length() < s2.length() ? 1 : -1;
        }
    };

    public int minimumLengthEncoding(String[] words) {
        PriorityQueue<String> pq = new PriorityQueue<>(comp);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            pq.add(words[i]);
        }
        int ret = 0;
        while (!pq.isEmpty()) {
            String s = pq.remove();
            if (!set.contains(s)) {
                ret += s.length() + 1;
                for (int i = 0; i < s.length(); i++) {
                    if (!set.add(s.substring(i))) {
                        break;
                    }
                }
            }
        }
        return ret;
    }
}

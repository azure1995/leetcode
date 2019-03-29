class WordFilter {
    trie root;

    public WordFilter(String[] words) {
        this.root = new trie();
        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length(); j >= 0; j--) {
                trie cur = root;
                String word = words[i].substring(j) + "#" + words[i];
                for (char ch : word.toCharArray()) {
                    int index = ch == '#' ? 26 : ch - 'a';
                    if (cur.next[index] == null) {
                        cur.next[index] = new trie();
                    }
                    cur = cur.next[index];
                    cur.w = i;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String target = suffix + "#" + prefix;
        trie cur = root;
        for (char ch : target.toCharArray()) {
            int index = ch == '#' ? 26 : ch - 'a';
            if (cur.next[index] == null) {
                return -1;
            }
            cur = cur.next[index];
        }
        return cur.w;
    }

    class trie {
        trie[] next = new trie[27];;
        int w;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such: WordFilter
 * obj = new WordFilter(words); int param_1 = obj.f(prefix,suffix);
 */

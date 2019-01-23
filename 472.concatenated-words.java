class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        buildTrie(root, words);
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (find(word.toCharArray(), 0, root, 0)) {
                ret.add(word);
            }
        }
        return ret;
    }

    private void buildTrie(Trie root, String[] words) {
        for (String word : words) {
            if (word.isEmpty()) continue;
            Trie cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.child[ch - 'a'] == null) {
                    cur.child[ch - 'a'] = new Trie();
                }
                cur = cur.child[ch - 'a'];
            }
            cur.isWord = true;
        }
    }

    private boolean find(char[] chArr, int from, Trie root, int count) {
        if (from == chArr.length) {
            return count >= 2;
        }
        Trie cur = root;
        for (int i = from; i < chArr.length; i++) {
            if (cur.child[chArr[i] - 'a'] == null) {
                return false;
            }
            cur = cur.child[chArr[i] - 'a'];
            if (cur.isWord && find(chArr, i + 1, root, count + 1)) {
                return true;
            }
        }
        return false;
    }

    class Trie {
        Trie[] child;
        boolean isWord;

        Trie() {
            this.child = new Trie[26];
            isWord = false;
        }
    }
}
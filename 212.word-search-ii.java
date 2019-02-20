class Solution {
    private void dfs(Set<String> set, TrieNode cur, char[][] board, int r, int c) {
        char ch = board[r][c];
        if (ch == '#' || cur.next[ch - 'a'] == null) {
            return;
        } 
        cur = cur.next[ch - 'a'];
        if (cur.word != null) {
            set.add(cur.word);
        }
        board[r][c] = '#';
        if (r - 1 >= 0) dfs(set, cur, board, r - 1, c);
        if (r + 1 < board.length) dfs(set, cur, board, r + 1, c);
        if (c - 1 >= 0) dfs(set, cur, board, r, c - 1);
        if (c + 1 < board[0].length) dfs(set, cur, board, r, c + 1);
        board[r][c] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = word;
        }
        Set<String> set = new HashSet<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(set, root, board, r, c);
            }
        }
        return new ArrayList<>(set);
    }

    class TrieNode {
        String word;
        TrieNode[] next;

        TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }
}
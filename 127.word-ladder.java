class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return 0;
        }
        return helper(beginWord, endWord, wordDict);
    }

    private int helper(String beginWord, String endWord, Set<String> wordDict) {
        int ans = 1;
        Set<String> head = new HashSet<>(Collections.singleton(beginWord));
        Set<String> tail = new HashSet<>(Collections.singleton(endWord));
        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                Set<String> temp = head;
                head = tail;
                tail = temp;
            }
            ans++;
            Set<String> temp = new HashSet<>();
            for (String word : head) {
                wordDict.remove(word);
                char[] cur = word.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char c = cur[j];
                    for (char r = 'a'; r <= 'z'; r++) {
                        if (r == c)
                            continue;
                        cur[j] = r;
                        String nextWord = new String(cur);
                        if (tail.contains(nextWord)) {
                            return ans;
                        } 
                        if (wordDict.contains(nextWord)) {
                            temp.add(nextWord);
                        }
                    }
                    cur[j] = c;
                }
            }
            for (String word : temp) {
                wordDict.remove(word);
            }
            head = temp;
        }
        return 0;
    }
}
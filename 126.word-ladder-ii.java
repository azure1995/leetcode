class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList();
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord))
            return ans;
        Map<String, List<String>> next = new HashMap<>();
        for (String word : wordDict) {
            next.put(word, new ArrayList<>());
        }
        next.put(beginWord, new ArrayList<>());
        if (buildNext(beginWord, endWord, wordDict, next)) {
            buildAns(beginWord, endWord, new LinkedList<>(Collections.singletonList(beginWord)), next, ans);
        }
        return ans;
    }

    private boolean buildNext(String beginWord, String endWord, Set<String> wordDict, Map<String, List<String>> next) {
        Set<String> head = new HashSet<>(Collections.singleton(beginWord));
        Set<String> tail = new HashSet<>(Collections.singleton(endWord));
        boolean found = false, headIsFront = true;
        while (!head.isEmpty() && !tail.isEmpty()) {
            if (head.size() > tail.size()) {
                Set<String> temp = head;
                head = tail;
                tail = temp;
                headIsFront = !headIsFront;
            }
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
                            found = true;
                        } else if (!found && wordDict.contains(nextWord) && !head.contains(nextWord)) {
                            temp.add(nextWord);
                        } else {
                            continue;
                        }
                        if (headIsFront) {
                            next.get(word).add(nextWord);
                        } else {
                            next.get(nextWord).add(word);
                        }
                    }
                    cur[j] = c;
                }
            }
            if (found) {
                return true;
            }
            head = temp;
        }
        return false;
    }

    private void buildAns(String beginString, String endString, LinkedList<String> list, Map<String, List<String>> next,
            List<List<String>> ans) {
        if (beginString.equals(endString)) {
            ans.add(new ArrayList(list));
            return;
        }
        for (String nextString : next.get(beginString)) {
            list.offerLast(nextString);
            buildAns(nextString, endString, list, next, ans);
            list.pollLast();
        }
    }
}
<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (21.33%)
 * Total Accepted:    196.1K
 * Total Submissions: 919.1K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        int word_length = wordList.get(0).length();
        int list_length = wordList.size();
        boolean[][] connect = new boolean[list_length][list_length];
        for (int i = 0; i < list_length - 1; i++) {
            for (int j = i + 1; j < list_length; j++) {
                int count = 0;
                for (int k = 0; k < word_length; k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        if (++count > 1) {
                            break;
                        }
                    }
                }
                if (count == 1) {
                    connect[i][j] = connect[j][i] = true;
                }
            }
        }
        int begin = wordList.indexOf(beginWord);
        int end = wordList.indexOf(endWord);
        boolean[] visited = new boolean[list_length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(begin);
        queue.add(-1);
        visited[begin] = true;
        int route = 1;
        while (!queue.isEmpty()) {
            int head = queue.remove();
            if (head == -1) {
                route++;
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(-1);
                }
            } else {
                if (head == end) {
                    return route;
                }
                for (int i = 0; i < list_length; i++) {
                    if (connect[i][head] && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}
=======
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
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284

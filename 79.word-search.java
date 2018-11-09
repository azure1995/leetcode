import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (29.06%)
 * Total Accepted:    212.1K
 * Total Submissions: 729.9K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    Map<Character, List<Integer>> map = new HashMap<>();
    boolean[] visited;
    String w;
    int r;
    int c;
    public boolean traverse (int index, int p) {
        if (index == w.length()) {
            return true;
        }
        for (Integer i : map.get(w.charAt(index))) {
            if ((p == -1 || (i/c == p/c && Math.abs(i - p) == 1) || (i%c == p%c && Math.abs(i - p) == c)) && !visited[i]) {
                visited[i] = true;
                if (traverse(index + 1, i)) {
                    return true;  
                }
                visited[i] = false;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        w = word;
        r = board.length;
        c = board[0].length;
        visited = new boolean[r*c];
        Arrays.fill(visited, false);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                List<Integer> list;
                if (!map.containsKey(board[i][j])) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(board[i][j]);
                }
                list.add(i*c + j);
                map.put(board[i][j], list);
            }
        }
        for (int i = 0; i < w.length(); i++) {
            if (!map.containsKey(w.charAt(i))) {
                return false;
            }
        }
        return traverse(0, -1);
    }
}

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int[][] map = new int[S.length()][26];
        for (int i = S.length() - 1; i >= 0; i--) {
            if (i < S.length() - 1)
                map[i] = map[i + 1].clone();
            map[i][S.charAt(i) - 'a'] = i + 1;
        }
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean is = true;
            for (int j = 0, st = 0; j < word.length(); j++) {
                if (st >= map.length || map[st][word.charAt(j) - 'a'] == 0) {
                    is = false;
                    break;
                }
                st = map[st][word.charAt(j) - 'a'];
            }
            if (is) {
                counter++;
            }
        }
        return counter;
    }
}
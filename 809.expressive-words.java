class Solution {
    public class ch {
        char c;
        int count;

        ch(char c) {
            this.c = c;
            this.count = 1;
        }
    }

    public int expressiveWords(String S, String[] words) {
        List<ch> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            ch c = new ch(S.charAt(i));
            while (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) {
                c.count++;
                i++;
            }
            list.add(c);
        }
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int j = 0, n = 0;
            while (j < word.length() && n < list.size()) {
                if (list.get(n).c != word.charAt(j))
                    break;
                int counter = 1;
                while (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                    counter++;
                    j++;
                }
                if (counter > list.get(n).count || (counter == 1 && list.get(n).count == 2)) {
                    break;
                }
                j++;
                n++;
            }
            if (j == word.length() && n == list.size()) {
                ret++;
            }
        }
        return ret;
    }
}

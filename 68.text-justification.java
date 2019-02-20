class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length(), cur = i;
            while (cur + 1 < words.length && len + 1 + words[cur + 1].length() <= maxWidth) {
                len += 1 + words[cur + 1].length();
                cur++;
            }
            if (cur == i) {
                ret.add(String.format("%-" + maxWidth + "s", words[i]));
            } else {
                int space = maxWidth - len + cur - i;
                StringBuilder sb = new StringBuilder(words[i]);
                for (int n = i + 1; n <= cur; n++) {
                    sb.append(cur == words.length - 1 ? " " : String.format("%" + space / (cur - i) + "s", ""));
                    if (cur != words.length - 1 && n <= i + space % (cur - i)) {
                        sb.append(" ");
                    }
                    sb.append(words[n]);
                }
                ret.add(String.format("%-" + maxWidth + "s", sb.toString()));
                i = cur;
            }
        }
        return ret;
    }
}

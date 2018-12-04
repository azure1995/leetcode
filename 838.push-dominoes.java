class Solution {
    public void append(StringBuilder sb, int num, char c) {
        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
    }

    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, pre = -1; i < dominoes.length(); i++) {
            while (i < dominoes.length() && dominoes.charAt(i) == '.') {
                i++;
            }
            if (i == dominoes.length() || dominoes.charAt(i) == 'R') {
                if (pre == -1 || dominoes.charAt(pre) == 'L') {
                    append(sb, i - pre - 1, '.');
                } else {
                    append(sb, i - pre - 1, 'R');
                }
                if (i < dominoes.length()) append(sb, 1, 'R');
            } else {
                if (pre == -1 || dominoes.charAt(pre) == 'L') {
                    append(sb, i - pre, 'L');
                } else {
                    append(sb, (i - pre - 1) / 2, 'R');
                    if ((i - pre - 1) % 2 == 1) {
                        append(sb, 1, '.');
                    }
                    append(sb, (i - pre + 1) / 2, 'L');
                }
            }
            pre = i;
        }
        return sb.toString();
    }
}

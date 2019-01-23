class Solution {
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s.charAt(i))) {
                int first = i;
                while (s.charAt(++i) != '[');
                int k = Integer.valueOf(s.substring(first, i));
                int counter = 1;
                int left = i + 1;
                do {
                    i++;
                    if (s.charAt(i) == '[') {
                        counter++;
                    } else if (s.charAt(i) == ']') {
                        counter--;
                    }
                } while (counter > 0);
                String subs = decodeString(s.substring(left, i));
                while (--k >= 0) {
                    sb.append(subs);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
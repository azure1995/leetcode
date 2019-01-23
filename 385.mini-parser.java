class Solution {
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        NestedInteger list = new NestedInteger();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '-' || isDigit(s.charAt(i))) {
                int first = i;
                while (++i < s.length() && isDigit(s.charAt(i)));
                int val = Integer.valueOf(s.substring(first, i));
                list.add(new NestedInteger(val));
                i--;
            } else if (s.charAt(i) == '[') {
                int left = i;
                int counter = 1;
                while (counter > 0) {
                    i++;
                    if (s.charAt(i) == '[') {
                        counter++;
                    } else if (s.charAt(i) == ']') {
                        counter--;
                    }
                }
                list.add(deserialize(s.substring(left, i + 1)));
            } 
        }
        return list;
    }
}
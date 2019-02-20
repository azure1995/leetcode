class Solution {
    public boolean isValid(String s) {
        return s.length() == 1 || s.charAt(0) != '0' || s.charAt(s.length() - 1) != '0';
    }

    public List<String> getComb(String s) {
        if (s.charAt(s.length() - 1) == '0') {
            return Collections.singletonList(s);
        } else if (s.charAt(0) == '0') {
            return Collections.singletonList("0." + s.substring(1));
        } 
        List<String> ret = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            ret.add(s.substring(0, i) + "." + s.substring(i));
        }
        ret.add(s);
        return ret;
    }

    public List<String> ambiguousCoordinates(String S) {
        List<String> ret = new ArrayList<>();
        for (int i = 2; i < S.length() - 1; i++) {
            if (isValid(S.substring(1, i)) && isValid(S.substring(i, S.length() - 1))) {
                List<String> list1 = getComb(S.substring(1, i));
                List<String> list2 = getComb(S.substring(i, S.length() - 1));
                for (int a = 0; a < list1.size(); a++) {
                    for (int b = 0; b < list2.size(); b++) {
                        ret.add("(" + list1.get(a) + ", " + list2.get(b) + ")");
                    }
                }
            }
        }
        return ret;
    }
}

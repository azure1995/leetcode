class Solution {
    Comparator<String> comp = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return s1.length() > s2.length() ? -1 : 1;
        }
    };

    public boolean isSubsequence(String subs, String s) {
        if (subs.length() > s.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < subs.length()) {
            while (j < s.length() && subs.charAt(i) != s.charAt(j++));
            if (j == s.length()) {
                if (i < subs.length() - 1 || subs.charAt(i) != s.charAt(j-1)) {
                    return false;
                }
            } else {
                if (s.length() - j + 1 < subs.length() - i) {
                    return false;
                }                
            }
            i++;
        }
        return true;
    }

    public int findLUSlength(String[] strs) {
        Set<String> single = new HashSet<>();
        Set<String> toTest = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (!single.contains(strs[i]) && !toTest.contains(strs[i])) {
                single.add(strs[i]);
            } else if (single.contains(strs[i]) && !toTest.contains(strs[i])) {
                single.remove(strs[i]);
                toTest.add(strs[i]);
            }
        }
        List<String> singleList = new ArrayList<>(single);
        Collections.sort(singleList, comp);
        for (int i = 0; i < singleList.size(); i++) {
            boolean valid = true;
            for (String s : toTest) {
                if (isSubsequence(singleList.get(i), s)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return singleList.get(i).length();
            } else {
                toTest.add(singleList.get(i));
            }
        }
        return -1;
    }
}
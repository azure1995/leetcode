class Solution {
    public String get(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() && s.charAt(i) != '+'; i++) {
            if (s.charAt(i) != '.') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < emails.length; i++) {
            String[] names = emails[i].split("@");
            if (!map.containsKey(names[1])) {
                map.put(names[1], new HashSet<>());
            }
            if (map.get(names[1]).add(get(names[0]))) {
                num++;
            }
        }
        return num;
    }
}
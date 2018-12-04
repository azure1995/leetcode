class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (sources[i].equals(targets[i]) || indexes[i] + sources[i].length() > S.length()) continue;
            if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) {
                map.put(indexes[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int st = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getKey();
            String source = sources[entry.getValue()];
            String target = targets[entry.getValue()];
            sb.append(S.substring(st, index));
            sb.append(target);
            st = index + source.length();
        }
        if (st < S.length()) {
            sb.append(S.substring(st));
        }
        return sb.toString();
    }
}

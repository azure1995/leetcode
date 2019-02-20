class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] global_counts = new int[26];
        for (String b : B) {
            int[] local_counts = new int[26];
            for (int i = 0; i < b.length(); i++) {
                local_counts[b.charAt(i) - 'a']++;
            }
            for (int c = 0; c < 26; c++) {
                global_counts[c] = Math.max(global_counts[c], local_counts[c]);
            }
        }
        java.util.List<String> ret = new ArrayList<>();
        for (String a : A) {
            int[] local_counts = new int[26];
            for (int i = 0; i < a.length(); i++) {
                local_counts[a.charAt(i) - 'a']++;
            }
            for (int c = 0; c <= 26; c++) {
                if (c == 26) {
                    ret.add(a);
                } else if (local_counts[c] < global_counts[c]) {
                    break;
                }
            }
        }
        return ret;
    }
}
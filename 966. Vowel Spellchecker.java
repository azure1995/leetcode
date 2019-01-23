class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> wordDic = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String word : wordlist) {
            String lower = word.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (!cap.containsKey(lower)) {
                cap.put(lower, word);
            }
            if (!vowel.containsKey(devowel)) {
                vowel.put(devowel, word);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (wordDic.contains(queries[i])) {
                continue;
            }
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}
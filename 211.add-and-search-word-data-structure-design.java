<<<<<<< HEAD

class WordDictionary {
    TrieNode root;

    public class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.children.containsKey(word.charAt(i))) {
                TrieNode newNode = new TrieNode();
                currentNode.children.put(word.charAt(i), newNode);
                currentNode = newNode;
            } else {
                currentNode = currentNode.children.get(word.charAt(i));
            }
        }
        currentNode.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean searchByLayer(String postFix, TrieNode r) {
        TrieNode currentNode = r;
        for (int i = 0; i < postFix.length(); i++) {
            if (postFix.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    if (currentNode.children.containsKey(c)
                            && searchByLayer(postFix.substring(i + 1), currentNode.children.get(c))) {
                        return true;
                    }
                }
                return false;
            } else if (!currentNode.children.containsKey(postFix.charAt(i))) {
                return false;
            } else {
                currentNode = currentNode.children.get(postFix.charAt(i));
            }
        }
        return currentNode.isWord;
    }

    public boolean search(String word) {
        return searchByLayer(word, root);
    }
=======

class WordDictionary {
    TrieNode root;

    public class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.children.containsKey(word.charAt(i))) {
                TrieNode newNode = new TrieNode();
                currentNode.children.put(word.charAt(i), newNode);
                currentNode = newNode;
            } else {
                currentNode = currentNode.children.get(word.charAt(i));
            }
        }
        currentNode.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean searchByLayer(String postFix, TrieNode r) {
        TrieNode currentNode = r;
        for (int i = 0; i < postFix.length(); i++) {
            if (postFix.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    if (currentNode.children.containsKey(c)
                            && searchByLayer(postFix.substring(i + 1), currentNode.children.get(c))) {
                        return true;
                    }
                }
                return false;
            } else if (!currentNode.children.containsKey(postFix.charAt(i))) {
                return false;
            } else {
                currentNode = currentNode.children.get(postFix.charAt(i));
            }
        }
        return currentNode.isWord;
    }

    public boolean search(String word) {
        return searchByLayer(word, root);
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}
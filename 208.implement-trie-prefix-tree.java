import java.util.HashMap;
import java.util.Map;

/*
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (34.02%)
 * Total Accepted:    138.2K
 * Total Submissions: 405.9K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
class Trie {

    TrieNode root;

    public class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.children.containsKey(word.charAt(i))) {
                return false;
            } else {
                currentNode = currentNode.children.get(word.charAt(i));
            }
        }
        return currentNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currentNode.children.containsKey(word.charAt(i))) {
                return false;
            } else {
                currentNode = currentNode.children.get(word.charAt(i));
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */

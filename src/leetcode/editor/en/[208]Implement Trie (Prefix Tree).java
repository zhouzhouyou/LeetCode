//Implement a trie with insert, search, and startsWith methods. 
//
// Example: 
//
// 
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
// 
//
// Note: 
//
// 
// You may assume that all inputs are consist of lowercase letters a-z. 
// All inputs are guaranteed to be non-empty strings. 
// 
// Related Topics Design Trie


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private class TrieNode {
        private Map<Character, TrieNode> map;
        private boolean end;

        public boolean isEnd() {
            return end;
        }

        public void setEnd() {
            end = true;
        }

        public boolean contains(char val) {
            return map.containsKey(val);
        }

        public TrieNode get(char val) {
            return map.get(val);
        }

        public TrieNode insertIfAbsent(char val) {
            if (!contains(val)) {
                TrieNode node = new TrieNode();
                map.put(val, node);
                return node;
            }
            return map.get(val);
        }

        public TrieNode() {
//            this.val = val;
            map = new HashMap<>();
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) cur = cur.insertIfAbsent(word.charAt(i));
        cur.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.contains(word.charAt(i))) return false;
            cur = cur.get(word.charAt(i));
        }
        return cur.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.contains(prefix.charAt(i))) return false;
            cur = cur.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

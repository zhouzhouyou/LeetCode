//Given a non-empty string s and a dictionary wordDict containing a list of non-
//empty words, determine if s can be segmented into a space-separated sequence of 
//one or more dictionary words. 
//
// Note: 
//
// 
// The same word in the dictionary may be reused multiple times in the segmentat
//ion. 
// You may assume the dictionary does not contain duplicate words. 
// 
//
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet", "code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//             Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output: false
// 
// Related Topics Dynamic Programming


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static class TrieNode {
        boolean isWord;
        TrieNode[] c;

        public TrieNode() {
            c= new TrieNode[128];
        }
    }

    private void addWord(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i);
            if (node.c[j] == null) node.c[j] = new TrieNode();
            node = node.c[j];
        }
        node.isWord = true;
    }

    private boolean startWith(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            cur = cur.c[word.charAt(i)];
            if (cur == null) return false;
        }
        return cur.isWord;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        wordDict.forEach(s1 -> addWord(s1, root));
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!f[i]) continue;
            for (int j = i; j < s.length(); j++) {
                if (f[j+1]) continue;
                String sub = s.substring(i, j + 1);
                if (startWith(sub, root)) f[j + 1] = true;
            }
        }
        return f[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

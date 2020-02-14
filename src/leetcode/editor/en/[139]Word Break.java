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
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new boolean[s.length()], 0);
    }

    private boolean backtrack(String s, List<String> dict, boolean[] dp, int begin) {
        if (begin == s.length()) return true;
        if (dp[begin]) return false;
        for (String w : dict) {
            if (s.startsWith(w, begin)) {
                if (backtrack(s, dict, dp, begin + w.length())) return true;
                dp[begin] = true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

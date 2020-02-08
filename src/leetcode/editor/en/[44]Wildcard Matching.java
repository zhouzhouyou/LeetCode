//Given an input string (s) and a pattern (p), implement wildcard pattern matchi
//ng with support for '?' and '*'. 
//
// 
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// ? or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input:
//s = "cb"
//p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
//ch 'b'.
// 
//
// Example 4: 
//
// 
//Input:
//s = "adceb"
//p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' ma
//tches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input:
//s = "acdcb"
//p = "a*c?b"
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int col = 1; col <= p.length(); col++) {
            if (p.charAt(col-1) == '*') dp[0][col] = dp[0][col-1];
        }
        for (int row = 1; row <= s.length(); row++) {
            for (int col = 1; col <= p.length(); col++) {
                char currS = s.charAt(row - 1);
                char currP = p.charAt(col - 1);
                if (currP == currS || currP == '?') dp[row][col] = dp[row-1][col-1];
                else if (currP == '*') dp[row][col] = dp[row - 1][col] || dp[row][col - 1];
            }
        }
        return dp[s.length()][p.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

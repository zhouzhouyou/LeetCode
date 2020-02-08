//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*'. 
//
// 
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// . or *. 
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
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int col = 1; col <= p.length(); col++) {
            if (p.charAt(col - 1) != '*') continue;
            dp[0][col] = dp[0][col - 2];
        }
        for (int row = 1; row <= s.length(); row++) {
            for (int col = 1; col <= p.length(); col++) {
                char currS = s.charAt(row - 1);
                char currP = p.charAt(col - 1);
                if (currS == currP || currP == '.') dp[row][col] = dp[row - 1][col - 1];
                else if (currP == '*') {
                    char preP = p.charAt(col - 2);
                    if (preP == currS || preP == '.')
                        dp[row][col] = dp[row - 1][col] || dp[row][col - 1] || dp[row][col - 2];
                    else dp[row][col] = dp[row][col - 2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

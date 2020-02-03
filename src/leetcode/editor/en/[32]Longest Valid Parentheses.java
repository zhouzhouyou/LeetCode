//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics String Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int maxP = 0;
        char close = ')';
        char open = '(';
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == close) {
                //close前面是open
                if (s.charAt(i - 1) == open) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i-1] > 0) {
                    //close前的一组parentheses的前面是open
                    if (s.charAt(i-dp[i-1] - 1) == open) {
                        dp[i] = dp[i-1];
                        dp[i] += (i - dp[i-1] >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
                    }
                }
            }
            maxP = Math.max(maxP, dp[i]);
        }
        return maxP;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

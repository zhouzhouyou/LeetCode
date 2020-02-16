//Initially on a notepad only one character 'A' is present. You can perform two 
//operations on this notepad for each step: 
//
// 
// Copy All: You can copy all the characters present on the notepad (partial cop
//y is not allowed). 
// Paste: You can paste the characters which are copied last time. 
// 
//
// 
//
// Given a number n. You have to get exactly n 'A' on the notepad by performing 
//the minimum number of steps permitted. Output the minimum number of steps to get
// n 'A'. 
//
// Example 1: 
//
// 
//Input: 3
//Output: 3
//Explanation:
//Intitally, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.
// 
//
// 
//
// Note: 
//
// 
// The n will be in the range [1, 1000]. 
// 
//
// 
// Related Topics Dynamic Programming


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                int k = i * j;
                dp[k] = Math.min(dp[k], dp[i] + j);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

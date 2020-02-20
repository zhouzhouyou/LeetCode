//
//You are given a list of non-negative integers, a1, a2, ..., an, and a target, 
//S. Now you have 2 symbols + and -. For each integer, you should choose one from 
//+ and - as its new symbol.
// 
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S. 
// 
//
// Example 1: 
// 
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
// 
//
// Note: 
// 
// The length of the given array is positive and will not exceed 20. 
// The sum of elements in the given array will not exceed 1000. 
// Your output answer is guaranteed to be fitted in a 32-bit integer. 
// 
// Related Topics Dynamic Programming Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(S>sum || S<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for (int num : nums) {
            int[] next = new int[2 * sum + 1];
            for (int k = 0; k < 2 * sum + 1; k++) {
                if (dp[k] != 0) {
                    next[k + num] += dp[k];
                    next[k - num] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+S];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

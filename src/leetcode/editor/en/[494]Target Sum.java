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
        for(int n: nums) sum += n;
        if (S < -sum || S > sum) { return 0;}

        int[][] dp = new int[nums.length + 1][ 2 * sum + 1];
        dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum,  check below graph
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j < 2 * sum + 1; j++){

                if(j + nums[i - 1] < 2  * sum + 1) dp[i][j] += dp[i - 1][j + nums[i - 1]];
                if(j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum + S];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

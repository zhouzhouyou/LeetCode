//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
//
// Example 2: 
//
// 
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if (len == 2) return Math.max(dp[0], dp[1]);
        dp[2] = dp[0] + nums[2];
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

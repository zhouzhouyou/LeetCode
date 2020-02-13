//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), prof
//it = 4-1 = 3. 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /*
        网上的方案：状态模式
        假定有以下状态：
            0：什么都没干，可以停留->0，也可以购买->1
            1：购买了一次股票，可以停留->0，也可以卖出->2
                收益s1为 -prices[i1]
            2：卖出过一次股票，可以停留->0，也可以购买->3
                收益s2为 prices[i2] + s1
            3：购买过两次股票，可以停留->0，也可以卖出->4
                收益s3为 s2 - prices[i3]
            4：卖出过两次股票
                收益s4为 prices[i4] + s3
         */
        if (prices.length < 2) return 0;
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = s2, s4 = s2;
        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(s4, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

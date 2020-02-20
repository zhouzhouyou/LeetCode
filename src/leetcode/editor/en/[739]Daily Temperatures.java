//
//Given a list of daily temperatures T, return a list such that, for each day in
// the input, tells you how many days you would have to wait until a warmer temper
//ature. If there is no future day for which this is possible, put 0 instead.
// 
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 7
//3], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// 
//
// Note:
//The length of temperatures will be in the range [1, 30000].
//Each temperature will be an integer in the range [30, 100].
// Related Topics Hash Table Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] dp = new int[len];
        dp[len-1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int cur = T[i];
            if (cur < T[i+1]) {
                dp[i] = 1;
                continue;
            }
            int left = i+1;
            int step = dp[left];
            while (step != 0) {
                if (cur < T[left+step]) {
                    dp[i] = left + step - i;
                    break;
                }
                left += step;
                step = dp[left];
            }
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) dp[size - 1][i] = triangle.get(size - 1).get(i);

        for (int row = size - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

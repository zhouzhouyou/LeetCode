//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown 
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia45 = new boolean[2 * n - 1];
        boolean[] dia135 = new boolean[2 * n - 1];
        helper(0, n, col, dia45, dia135);
        return result;
    }

    private void helper(int row, int n, boolean[] column, boolean[] dia45, boolean[] dia135) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!column[col] && !dia45[col + row] && !dia135[n - 1 - row + col]) {
                column[col] = dia45[col + row] = dia135[n - 1 - row + col] = true;
                helper(row + 1, n, column, dia45, dia135);
                column[col] = dia45[col + row] = dia135[n - 1 - row + col] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

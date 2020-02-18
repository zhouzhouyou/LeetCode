//Given a matrix, and a target, return the number of non-empty submatrices that 
//sum to target. 
//
// A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x 
//<= x2 and y1 <= y <= y2. 
//
// Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if th
//ey have some coordinate that is different: for example, if x1 != x1'. 
//
// 
//
// Example 1: 
//
// 
//Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
//Output: 4
//Explanation: The four 1x1 submatrices that only contain 0.
// 
//
// 
// Example 2: 
//
// 
//Input: matrix = [[1,-1],[-1,1]], target = 0
//Output: 5
//Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2
//x2 submatrix.
// 
// 
//
// 
//
// Note: 
//
// 
// 1 <= matrix.length <= 300 
// 1 <= matrix[0].length <= 300 
// -1000 <= matrix[i] <= 1000 
// -10^8 <= target <= 10^8 
// 
// Related Topics Array Dynamic Programming Sliding Window


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int ans = 0;
        for (int left = 0; left < cols; left++) {
            int[] dp = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) dp[i] += matrix[i][right];

                for (int top = 0; top < rows; top++) {
                    int sum = 0;
                    for (int down = top; down < rows; down++) {
                        sum += dp[down];
                        if (sum == target) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

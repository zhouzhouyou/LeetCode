//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        if (matrix[0].length == 0) return ans;
        dfs(ans, 0, 0, matrix, new boolean[matrix.length][matrix[0].length], 0);
        return ans;
    }

    private void dfs(List<Integer> path, int row, int col, int[][] matrix, boolean[][] used, int direct) {
        used[row][col] = true;
        path.add(matrix[row][col]);
        if (direct == 0) {
            if (col < matrix[row].length - 1 && !used[row][col+1]) {
                dfs(path, row, col + 1, matrix, used, 0);
            } else if (row < matrix.length - 1 && !used[row + 1][col]) {
                dfs(path, row + 1, col, matrix, used, 1);
            }
        } else if (direct == 1) {
            if (row < matrix.length - 1 && !used[row + 1][col]) {
                dfs(path, row + 1, col, matrix, used, 1);
            } else if (col > 0 && !used[row][col - 1]) {
                dfs(path, row, col - 1, matrix, used, 2);
            }
        } else if (direct == 2) {
            if (col > 0 && !used[row][col - 1]) {
                dfs(path, row, col - 1, matrix, used, 2);
            } else if (row > 0 && !used[row - 1][col]) {
                dfs(path, row - 1, col, matrix, used, 3);
            }
        } else if (direct == 3) {
            if (row > 0 && !used[row - 1][col]) {
                dfs(path, row - 1, col, matrix, used, 3);
            } else if (col < matrix[row].length - 1 && !used[row][col+1]) {
                dfs(path, row, col + 1, matrix, used, 0);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
